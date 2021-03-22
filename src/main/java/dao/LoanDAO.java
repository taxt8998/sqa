package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoanDAO extends DAO{
    public LoanDAO() {
        super();
    }
    public ArrayList<Loan> getLoan(int page) throws SQLException {
        ArrayList<Loan> kq = new ArrayList<Loan>();
        int quantity = 10;
        int start = (page - 1)*quantity;
        String sql = "SELECT l.id as loan_id, l.amount, l.mortgate, l.duration, " +
                "l.start_date , l.end_date, l.cur_rate, l.branch_id, " +
                "a.id as account_id, a.openDate, a.card_id, " +
                "u.id as user_id, u.u_name, u.birth, " +
                "lt.id as loantype_id, lt.loan_name, lt.rate, lt.description, lt.duration as loan_duration, " +
                "br.branch_name, br.location, " +
                "ct.id as custype_id, ct.custype_name " +
                "FROM tblloan as l " +
                "JOIN tblaccount as a on l.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "JOIN tblloantype as lt on l.loantype_id = lt.id " +
                "JOIN tblbranch as br on l.branch_id = br.id " +
                "JOIN tblcustomertype as ct on a.custype_id = ct.id " +
                "ORDER BY start_date "+
                "LIMIT ? OFFSET ? " ;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,quantity);
        ps.setInt(2,start);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Loan l = new Loan();
            l.setId(rs.getInt("loan_id"));
            l.setAmount(rs.getFloat("amount"));
            l.setStartDate(rs.getDate("start_date"));
            l.setEndDate(rs.getDate("end_date"));
            l.setCurRate(rs.getInt("cur_rate"));
            l.setMortgate(rs.getString("mortgate"));
            l.setDuration(rs.getInt("duration"));
            Customer c = new Customer();
            c.setId(rs.getInt("user_id"));
            c.setName(rs.getString("u_name"));
            c.setBirth(rs.getDate("birth"));
            CustomerType ct = new CustomerType();
            ct.setId(rs.getInt("custype_id"));
            ct.setName(rs.getString("custype_name"));
            Account acc = new Account();
            acc.setId(rs.getInt("account_id"));
            acc.setOpenDate(rs.getDate("openDate"));
            acc.setCardId(rs.getString("card_id"));
            acc.setCustomer(c);
            acc.setCustomerType(ct);
            l.setAccount(acc);
            LoanType lt = new LoanType();
            lt.setId(rs.getInt("loantype_id"));
            lt.setName(rs.getString("loan_name"));
            lt.setRate(rs.getInt("rate"));
            lt.setDescription(rs.getString("description"));
            lt.setDuration(rs.getInt("loan_duration"));
            l.setLoanType(lt);
            Branch br = new Branch();
            br.setId(rs.getInt("branch_id"));
            br.setName(rs.getString("branch_name"));
            br.setAddress(rs.getString("location"));
            l.setBranch(br);
            kq.add(l);
        }

        return kq;
    }
    public int getTotal() throws SQLException {
        int kq =0;
        String sql="SELECT count(id) as total from tblloan";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
}

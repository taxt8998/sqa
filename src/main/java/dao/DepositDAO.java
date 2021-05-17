package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepositDAO extends DAO{
    public DepositDAO() {
        super();
    }
    public ArrayList<Deposit> getDeposit(int page) throws SQLException {
        ArrayList<Deposit> kq = new ArrayList<Deposit>();
        if(page <= 0) return null;
        int quantity = 10;
        int start = (page - 1)*quantity;
        String sql = "SELECT d.id as deposit_id, d.amount, d.duration, " +
                "d.deposit_date , d.withdraw_date, d.cur_rate, d.branch_id, " +
                "a.id as account_id, a.openDate, a.card_id, " +
                "u.id as user_id, u.u_name, u.birth, " +
                "dt.id as deptype_id, dt.deptype_name, dt.rate, dt.description, dt.duration as dep_duration, " +
                "br.branch_name, br.location, " +
                "ct.id as custype_id, ct.custype_name " +
                "FROM tbldeposit as d " +
                "JOIN tblaccount as a on d.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "JOIN tbldeposittype as dt on d.deptype_id = dt.id " +
                "JOIN tblbranch as br on d.branch_id = br.id " +
                "JOIN tblcustomertype as ct on a.custype_id = ct.id " +
                "ORDER BY deposit_date desc "+
                "LIMIT ? OFFSET ? " ;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,quantity);
        ps.setInt(2,start);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Deposit d = new Deposit();
            d.setId(rs.getInt("deposit_id"));
            d.setAmount(rs.getDouble("amount"));
            d.setDepositDate(rs.getDate("deposit_date"));
            d.setWithdraw_date(rs.getDate("withdraw_date"));
            d.setCurRate(rs.getDouble("cur_rate"));
            d.setDuration(rs.getInt("duration"));
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
            d.setAccount(acc);
            DepositType dt = new DepositType();
            dt.setId(rs.getInt("deptype_id"));
            dt.setName(rs.getString("deptype_name"));
            dt.setRate(rs.getInt("rate"));
            dt.setDescription(rs.getString("description"));
            dt.setDuration(rs.getInt("dep_duration"));
            d.setDepositType(dt);
            Branch br = new Branch();
            br.setId(rs.getInt("branch_id"));
            br.setName(rs.getString("branch_name"));
            br.setAddress(rs.getString("location"));
            d.setBranch(br);
            kq.add(d);
        }

        return kq;
    }
    public int getTotal() throws SQLException {
        int kq =0;
        String sql="SELECT count(id) as total from tbldeposit";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public Deposit getDepositDetail(int id) throws SQLException{
        Deposit d = null;
        String sql = "SELECT d.id as deposit_id, d.amount, d.duration, " +
                "d.deposit_date , d.withdraw_date, d.cur_rate, d.branch_id, " +
                "a.id as account_id, a.openDate, a.card_id, " +
                "u.id as user_id, u.u_name, u.birth, " +
                "dt.id as deptype_id, dt.deptype_name, dt.rate, dt.description, dt.duration as dep_duration, " +
                "br.branch_name, br.location, " +
                "ct.id as custype_id, ct.custype_name " +
                "FROM tbldeposit as d " +
                "JOIN tblaccount as a on d.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "JOIN tbldeposittype as dt on d.deptype_id = dt.id " +
                "JOIN tblbranch as br on d.branch_id = br.id " +
                "JOIN tblcustomertype as ct on a.custype_id = ct.id " +
                "WHERE d.id = ?" ;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            d = new Deposit();
            d.setId(rs.getInt("deposit_id"));
            d.setAmount(rs.getDouble("amount"));
            d.setDepositDate(rs.getDate("deposit_date"));
            d.setWithdraw_date(rs.getDate("withdraw_date"));
            d.setCurRate(rs.getDouble("cur_rate"));
            d.setDuration(rs.getInt("duration"));
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
            d.setAccount(acc);
            DepositType dt = new DepositType();
            dt.setId(rs.getInt("deptype_id"));
            dt.setName(rs.getString("deptype_name"));
            dt.setRate(rs.getInt("rate"));
            dt.setDescription(rs.getString("description"));
            dt.setDuration(rs.getInt("dep_duration"));
            d.setDepositType(dt);
            Branch br = new Branch();
            br.setId(rs.getInt("branch_id"));
            br.setName(rs.getString("branch_name"));
            br.setAddress(rs.getString("location"));
            d.setBranch(br);
        }
        return d;
    }
}

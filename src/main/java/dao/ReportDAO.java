package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReportDAO extends DAO{
    public ReportDAO() {
        super();
    }

    public ArrayList<Loan> getMonthReportLoan(int month,int year,int page) throws SQLException {
        int quantity = 10;
        int start = (page - 1)*quantity;
        ArrayList<Loan> listLoan = new ArrayList<Loan>();
        if(page <= 0) return null;
        String sql = "SELECT l.id as loan_id, l.amount, " +
                "l.start_date, u.u_name,  " +
                "a.id as account_id  " +
                "FROM tblloan as l " +
                "JOIN tblaccount as a on l.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "WHERE DATE_FORMAT(start_date,\"%m\") = ? AND DATE_FORMAT(start_date,\"%Y\") = ? " +
                "ORDER BY start_date desc "+
                "LIMIT ? OFFSET ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,month);
        ps.setInt(2,year);
        ps.setInt(3,quantity);
        ps.setInt(4,start);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Loan loan = new Loan();
            loan.setId(rs.getInt("loan_id"));
            loan.setAmount(rs.getDouble("amount"));
            loan.setStartDate(rs.getDate("start_date"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer = new Customer();
            customer.setName(rs.getString("u_name"));
            account.setCustomer(customer);
            loan.setAccount(account);
            listLoan.add(loan);
        }
        return  listLoan;
    }
    public ArrayList<Loan> getYearReportLoan(int year,int page) throws SQLException {
        int quantity = 10;
        int start = (page - 1)*quantity;
        ArrayList<Loan> listLoan = new ArrayList<Loan>();
        if(page <= 0) return null;
        String sql = "SELECT l.id as loan_id, l.amount, " +
                "l.start_date, u.u_name,  " +
                "a.id as account_id " +
                "FROM tblloan as l " +
                "JOIN tblaccount as a on l.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "WHERE DATE_FORMAT(start_date,\"%Y\") = ? " +
                "ORDER BY start_date desc "+
                "LIMIT ? OFFSET ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ps.setInt(2,quantity);
        ps.setInt(3,start);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Loan loan = new Loan();
            loan.setId(rs.getInt("loan_id"));
            loan.setAmount(rs.getDouble("amount"));
            loan.setStartDate(rs.getDate("start_date"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer = new Customer();
            customer.setName(rs.getString("u_name"));
            account.setCustomer(customer);
            loan.setAccount(account);
            listLoan.add(loan);
        }
        return  listLoan;
    }
    public ArrayList<Loan> getQuarterReportLoan(int quarter, int year, int page) throws Exception, SQLException {
        int quantity = 10;
        int start = (page - 1)*quantity;
        if (quarter != 1 && quarter != 2 && quarter != 3 && quarter != 4) throw new Exception("Quý ko hợp lệ");
        String months = "";
        if(quarter == 1) months = "(1,2,3)";
        else if(quarter == 2) months = "(4,5,6)";
        else if(quarter == 3) months = "(7,8,9)";
        else if(quarter == 4) months = "(10,11,12)";
        ArrayList<Loan> listLoan = new ArrayList<Loan>();
        if(page <= 0) return null;
        String sql = "SELECT l.id as loan_id, l.amount, " +
                "l.start_date, u.u_name,  " +
                "a.id as account_id  " +
                "FROM tblloan as l " +
                "JOIN tblaccount as a on l.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "WHERE DATE_FORMAT(start_date,\"%m\") in "+months+" AND DATE_FORMAT(start_date,\"%Y\") = ? " +
                "ORDER BY start_date desc "+
                "LIMIT ? OFFSET ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ps.setInt(2,quantity);
        ps.setInt(3,start);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Loan loan = new Loan();
            loan.setId(rs.getInt("loan_id"));
            loan.setAmount(rs.getDouble("amount"));
            loan.setStartDate(rs.getDate("start_date"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer = new Customer();
            customer.setName(rs.getString("u_name"));
            account.setCustomer(customer);
            loan.setAccount(account);
            listLoan.add(loan);
        }
        return  listLoan;
    }
    public int getMonthQuantity(int month, int year) throws SQLException{
        int kq =0;
        String sql="SELECT count(id) as total from tblloan " +
                "WHERE DATE_FORMAT(start_date,\"%m\") = ? AND DATE_FORMAT(start_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,month);
        ps.setInt(2,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public int getQuarterQuantity(int quarter, int year) throws SQLException,Exception{
        int kq =0;
        if (quarter != 1 && quarter != 2 && quarter != 3 && quarter != 4) throw new Exception("Quý ko hợp lệ");
        String months = "";
        if(quarter == 1) months = "(1,2,3)";
        else if(quarter == 2) months = "(4,5,6)";
        else if(quarter == 3) months = "(7,8,9)";
        else if(quarter == 4) months = "(10,11,12)";
        String sql="SELECT count(id) as total from tblloan " +
                "WHERE DATE_FORMAT(start_date,\"%m\") in "+months+" AND DATE_FORMAT(start_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public int getYearQuantity(int year) throws SQLException{
        int kq =0;
        String sql="SELECT count(id) as total from tblloan " +
                "WHERE DATE_FORMAT(start_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public double getMonthTotal(int month, int year) throws SQLException{
        double kq =0;
        String sql="SELECT sum(amount) as total from tblloan " +
                "WHERE DATE_FORMAT(start_date,\"%m\") = ? AND DATE_FORMAT(start_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,month);
        ps.setInt(2,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public double getQuarterTotal(int quarter, int year) throws SQLException,Exception{
        double kq =0;
        if (quarter != 1 && quarter != 2 && quarter != 3 && quarter != 4) throw new Exception("Quý ko hợp lệ");
        String months = "";
        if(quarter == 1) months = "(1,2,3)";
        else if(quarter == 2) months = "(4,5,6)";
        else if(quarter == 3) months = "(7,8,9)";
        else if(quarter == 4) months = "(10,11,12)";
        String sql="SELECT sum(amount) as total from tblloan " +
                "WHERE DATE_FORMAT(start_date,\"%m\") in "+months+" AND DATE_FORMAT(start_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public double getYearTotal(int year) throws SQLException{
        double kq =0;
        String sql="SELECT sum(amount) as total from tblloan " +
                "WHERE DATE_FORMAT(start_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }

    public ArrayList<Deposit> getMonthReportDeposit(int month,int year,int page) throws SQLException {
        int quantity = 10;
        int start = (page - 1)*quantity;
        ArrayList<Deposit> listDeposit = new ArrayList<Deposit>();
        if(page <= 0) return null;
        String sql = "SELECT d.id as deposit_id, d.amount, " +
                "d.deposit_date ,  " +
                "a.id as account_id, " +
                "u.u_name " +
                "FROM tbldeposit as d " +
                "JOIN tblaccount as a on d.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "WHERE DATE_FORMAT(deposit_date,\"%m\") = ? AND DATE_FORMAT(deposit_date,\"%Y\") = ? " +
                "ORDER BY deposit_date desc "+
                "LIMIT ? OFFSET ? " ;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,month);
        ps.setInt(2,year);
        ps.setInt(3,quantity);
        ps.setInt(4,start);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Deposit deposit = new Deposit();
            deposit.setId(rs.getInt("deposit_id"));
            deposit.setAmount(rs.getDouble("amount"));
            deposit.setDepositDate(rs.getDate("deposit_date"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer = new Customer();
            customer.setName(rs.getString("u_name"));
            account.setCustomer(customer);
            deposit.setAccount(account);
            listDeposit.add(deposit);
        }
        return  listDeposit;
    }
    public ArrayList<Deposit> getYearReportDeposit(int year,int page) throws SQLException {
        int quantity = 10;
        int start = (page - 1)*quantity;
        ArrayList<Deposit> listDeposit = new ArrayList<Deposit>();
        if(page <= 0) return null;
        String sql = "SELECT d.id as deposit_id, d.amount, " +
                "d.deposit_date ,  " +
                "a.id as account_id, " +
                "u.u_name " +
                "FROM tbldeposit as d " +
                "JOIN tblaccount as a on d.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "WHERE DATE_FORMAT(deposit_date,\"%Y\") = ? " +
                "ORDER BY deposit_date desc "+
                "LIMIT ? OFFSET ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ps.setInt(2,quantity);
        ps.setInt(3,start);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Deposit deposit = new Deposit();
            deposit.setId(rs.getInt("deposit_id"));
            deposit.setAmount(rs.getDouble("amount"));
            deposit.setDepositDate(rs.getDate("deposit_date"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer = new Customer();
            customer.setName(rs.getString("u_name"));
            account.setCustomer(customer);
            deposit.setAccount(account);
            listDeposit.add(deposit);
        }
        return  listDeposit;
    }
    public ArrayList<Deposit> getQuarterReportDeposit(int quarter, int year, int page) throws Exception, SQLException {
        int quantity = 10;
        int start = (page - 1)*quantity;
        if (quarter != 1 && quarter != 2 && quarter != 3 && quarter != 4) throw new Exception("Quý ko hợp lệ");
        String months = "";
        if(quarter == 1) months = "(1,2,3)";
        else if(quarter == 2) months = "(4,5,6)";
        else if(quarter == 3) months = "(7,8,9)";
        else if(quarter == 4) months = "(10,11,12)";
        ArrayList<Deposit> listDeposit = new ArrayList<Deposit>();
        if(page <= 0) return null;
        String sql = "SELECT d.id as deposit_id, d.amount, " +
                "d.deposit_date ,  " +
                "a.id as account_id, " +
                "u.u_name " +
                "FROM tbldeposit as d " +
                "JOIN tblaccount as a on d.account_id = a.id " +
                "JOIN tbluser as u on a.user_id = u.id " +
                "WHERE DATE_FORMAT(deposit_date,\"%m\") in "+months+" AND DATE_FORMAT(deposit_date,\"%Y\") = ? " +
                "ORDER BY deposit_date desc "+
                "LIMIT ? OFFSET ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ps.setInt(2,quantity);
        ps.setInt(3,start);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Deposit deposit = new Deposit();
            deposit.setId(rs.getInt("deposit_id"));
            deposit.setAmount(rs.getDouble("amount"));
            deposit.setDepositDate(rs.getDate("deposit_date"));
            Account account = new Account();
            account.setId(rs.getInt("account_id"));
            Customer customer = new Customer();
            customer.setName(rs.getString("u_name"));
            account.setCustomer(customer);
            deposit.setAccount(account);
            listDeposit.add(deposit);
        }
        return  listDeposit;
    }
    public int getMonthQuantityDeposit(int month, int year) throws SQLException{
        int kq =0;
        String sql="SELECT count(id) as total from tbldeposit " +
                "WHERE DATE_FORMAT(deposit_date,\"%m\") = ? AND DATE_FORMAT(deposit_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,month);
        ps.setInt(2,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public int getQuarterQuantityDeposit(int quarter, int year) throws SQLException,Exception{
        int kq =0;
        if (quarter != 1 && quarter != 2 && quarter != 3 && quarter != 4) throw new Exception("Quý ko hợp lệ");
        String months = "";
        if(quarter == 1) months = "(1,2,3)";
        else if(quarter == 2) months = "(4,5,6)";
        else if(quarter == 3) months = "(7,8,9)";
        else if(quarter == 4) months = "(10,11,12)";
        String sql="SELECT count(id) as total from tbldeposit " +
                "WHERE DATE_FORMAT(deposit_date,\"%m\") in "+months+" AND DATE_FORMAT(deposit_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public int getYearQuantityDeposit(int year) throws SQLException{
        int kq =0;
        String sql="SELECT count(id) as total from tbldeposit " +
                "WHERE DATE_FORMAT(deposit_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public double getMonthTotalDeposit(int month, int year) throws SQLException{
        double kq =0;
        String sql="SELECT sum(amount) as total from tbldeposit " +
                "WHERE DATE_FORMAT(deposit_date,\"%m\") = ? AND DATE_FORMAT(deposit_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,month);
        ps.setInt(2,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public double getQuarterTotalDeposit(int quarter, int year) throws SQLException,Exception{
        double kq =0;
        if (quarter != 1 && quarter != 2 && quarter != 3 && quarter != 4) throw new Exception("Quý ko hợp lệ");
        String months = "";
        if(quarter == 1) months = "(1,2,3)";
        else if(quarter == 2) months = "(4,5,6)";
        else if(quarter == 3) months = "(7,8,9)";
        else if(quarter == 4) months = "(10,11,12)";
        String sql="SELECT sum(amount) as total from tbldeposit " +
                "WHERE DATE_FORMAT(deposit_date,\"%m\") in "+months+" AND DATE_FORMAT(deposit_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();;
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
    public double getYearTotalDeposit(int year) throws SQLException{
        double kq =0;
        String sql="SELECT sum(amount) as total from tbldeposit " +
                "WHERE DATE_FORMAT(deposit_date,\"%Y\") = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,year);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) kq = rs.getInt("total");
        return kq;
    }
}

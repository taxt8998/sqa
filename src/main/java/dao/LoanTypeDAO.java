/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LoanType;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class LoanTypeDAO extends DAO {

    public LoanTypeDAO() {
        super();
    }

    public ArrayList<LoanType> getAllLoanType() {
        ArrayList<LoanType> result = null;
        String sql = "{call getloan}";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                LoanType lt = new LoanType();
                lt.setId(rs.getInt("id"));
                lt.setName(rs.getString("loan_name"));
                lt.setRate(rs.getDouble("rate"));
                lt.setDuration(rs.getInt("duration"));
                lt.setDescription(rs.getString("description"));

                result.add(lt);
            }
        } catch (SQLException e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }

    public boolean saveLoanRate(ArrayList<LoanType> choseLoan) {
        boolean kq = false;
        String sql_lock = "SELECT * FROM tblloantype WHERE id=? FOR UPDATE";
        String sql_update = "UPDATE tblloantype SET rate=? WHERE id=?";
        try {
            this.connection.setAutoCommit(false);
            for (int i = 0; i < choseLoan.size(); i++) {
                PreparedStatement ps0 = connection.prepareStatement(sql_lock);
                ps0.setInt(1, choseLoan.get(i).getId());
                ps0.execute();
                PreparedStatement ps1 = connection.prepareStatement(sql_update);
                ps1.setDouble(1, choseLoan.get(i).getRate());
                ps1.setInt(2, choseLoan.get(i).getId());
                ps1.executeUpdate();
            }
            this.connection.commit();//cmt dong nay ney chay che do JUnit test
            kq = true;
        } catch (SQLException e) {
            try {
                this.connection.rollback();//cmt dong nay ney chay che do JUnit test
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }

        return kq;
    }

    public boolean checkExistLoan(String s) {
        boolean kq = true;
        String sql = "{call checkloan(?)}";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            cs.setString(1, s);
            ResultSet rs = cs.executeQuery();
            if (!rs.next()) {
                kq = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kq;
    }

    public boolean addLoanType(ArrayList<LoanType> lt) {
        boolean kq = false;
        String insert = "INSERT INTO tblloantype(loan_name,rate,description,duration) VALUES (?,?,?,?)";
        try {
            this.connection.setAutoCommit(false);
            for (int i = 0; i < lt.size(); i++) {
                PreparedStatement ps = connection.prepareStatement(insert);
                ps.setString(1, lt.get(i).getName());
                ps.setDouble(2, lt.get(i).getRate());
                ps.setString(3, lt.get(i).getDescription());
                ps.setInt(4, lt.get(i).getDuration());
                ps.executeUpdate();
            }
            this.connection.commit();
            kq = true;

        } catch (SQLException ex) {
            try {
                this.connection.rollback();//cmt dong nay ney chay che do JUnit test
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }
        return kq;
    }

    public boolean deleteLoan(LoanType lt) {

        boolean kq = false;
        String delete_sql1 = "DELETE FROM tblloan WHERE loantype_id=?";
        String delete_sql2 = "DELETE FROM tblloantype WHERE loan_name=?";
        try {
            this.connection.setAutoCommit(false);
            PreparedStatement ps1 = connection.prepareStatement(delete_sql1);
            ps1.setInt(1, lt.getId());
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(delete_sql2);
            ps2.setString(1, lt.getName());
            ps2.executeUpdate();
            this.connection.commit();//cmt dong nay ney chay che do JUnit test
            kq = true;
            
        } catch (SQLException e) {
            try {
                this.connection.rollback();//cmt dong nay ney chay che do JUnit test
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }
        return kq;
    }
}

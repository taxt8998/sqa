/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DepositType;
import model.LoanType;

/**
 *
 * @author ASUS
 */
public class DepositTypeDAO extends DAO {

    public DepositTypeDAO() {
        super();
    }
    public Connection getDAOConnection(){
        String DB_NAME = "banksystem";
        String USER_NAME = "root";
        String PASSWORD = "771990tt";
        Connection connection = null;
        String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME+"?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF8";
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                System.out.println("connect successfully!");
            } catch (Exception ex) {
                System.out.println("connect failure!");
                ex.printStackTrace();
            }
        return connection;
    }

    public ArrayList<DepositType> getAllDepositType() {
        ArrayList<DepositType> result = null;
        String sql = "{call getdeposit}";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                DepositType dt = new DepositType();
                dt.setId(rs.getInt("id"));
                dt.setName(rs.getString("deptype_name"));
                dt.setRate(rs.getDouble("rate"));
                dt.setDuration(rs.getInt("duration"));
                dt.setDescription(rs.getString("description"));

                result.add(dt);
            }

        } catch (SQLException e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }

    public boolean saveDepRate(ArrayList<DepositType> choseDep) {
        boolean kq = false;
        String sql_lock = "SELECT * FROM tbldeposittype WHERE id=? FOR UPDATE";
        String sql_update = "UPDATE tbldeposittype SET rate=? WHERE id=?";
        try {
            this.connection.setAutoCommit(false);
            for (int i = 0; i < choseDep.size(); i++) {
                PreparedStatement ps0 = connection.prepareStatement(sql_lock);
                ps0.setInt(1, choseDep.get(i).getId());
                ps0.execute();
                PreparedStatement ps1 = connection.prepareStatement(sql_update);
                ps1.setDouble(1, choseDep.get(i).getRate());
                ps1.setInt(2, choseDep.get(i).getId());
                ps1.executeUpdate();
            }
            //this.connection.commit();//cmt dong nay ney chay che do JUnit test
            kq = true;
        } catch (SQLException e) {
            try {
                //this.connection.rollback();//cmt dong nay ney chay che do JUnit test
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                //this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }

        return kq;
    }
    
    public boolean checkExistDeposit(String s) {
        boolean kq = true;
        String sql = "{call checkdep(?)}";
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
    
    public boolean addDepType(ArrayList<DepositType> dt) {
        boolean kq = false;
        String insert = "INSERT INTO tbldeposittype(deptype_name,rate,description,duration) VALUES (?,?,?,?)";
        try {
            this.connection.setAutoCommit(false);
            for (int i = 0; i < dt.size(); i++) {
                PreparedStatement ps = connection.prepareStatement(insert);
                ps.setString(1, dt.get(i).getName());
                ps.setDouble(2, dt.get(i).getRate());
                ps.setString(3, dt.get(i).getDescription());
                ps.setInt(4, dt.get(i).getDuration());
                ps.executeUpdate();
            }
            //this.connection.commit();
            kq = true;

        } catch (SQLException ex) {
            try {
                //this.connection.rollback();//cmt dong nay ney chay che do JUnit test
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                //this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }
        return kq;
    }
    
//        public boolean deleteDep(DepositType dt) {
//
//        boolean kq = false;
//        String delete_sql1 = "DELETE FROM tbldeposit WHERE deptype_id=?";
//        String delete_sql2 = "DELETE FROM tbldeposittype WHERE deptype_name=?";
//        try {
//            this.connection.setAutoCommit(false);
//            PreparedStatement ps1 = connection.prepareStatement(delete_sql1);
//            ps1.setInt(1, dt.getId());
//            ps1.executeUpdate();
//            PreparedStatement ps2 = connection.prepareStatement(delete_sql2);
//            ps2.setString(1, dt.getName());
//            ps2.executeUpdate();
//            this.connection.commit();//cmt dong nay ney chay che do JUnit test
//            kq = true;
//            
//        } catch (SQLException e) {
//            try {
//                this.connection.rollback();//cmt dong nay ney chay che do JUnit test
//            } catch (Exception ee) {
//                kq = false;
//                ee.printStackTrace();
//            }
//            e.printStackTrace();
//        } finally {
//            try {
//                this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
//            } catch (Exception e) {
//                kq = false;
//                e.printStackTrace();
//            }
//        }
//        return kq;
//    }
}

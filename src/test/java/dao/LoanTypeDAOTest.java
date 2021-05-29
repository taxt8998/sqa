/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.LoanType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author ASUS
 */
public class LoanTypeDAOTest {
    
    public LoanTypeDAOTest() {
    }

    @Test
    public void testGetAllLoanType() {
        ArrayList<LoanType> list = new ArrayList<>();
        list.add(new LoanType(1, "Vay tin chap", "ap dung voi tai khoan vang", 20.01, 60));
        list.add(new LoanType(2, "Vay tin chap", "ap dung voi tai khoan bac", 11.2, 50));
        list.add(new LoanType(3, "Vay tin chap", "ap dung voi tai khoan dong", 12.96, 30));
        list.add(new LoanType(4, "Vay the chap mua nha", "ap dung voi tai khoan vang", 7, 300));
        list.add(new LoanType(5, "Vay the chap mua nha", "ap dung voi tai khoan bac", 0, 300));
        list.add(new LoanType(6, "Vay the chap mua nha", "ap dung voi tai khoan dong", 21, 300));
        LoanTypeDAO dao = new LoanTypeDAO();
        ArrayList<LoanType> test = dao.getAllLoanType();
        assertEquals(list, test);
    }

//    @Test
//    public void testSaveLoanRate() {
//        LoanTypeDAO dao = new LoanTypeDAO();
//        boolean t =true;
//        ArrayList<LoanType> list = new ArrayList<>();
//        list.add(new LoanType(1, "Vay tin chap", "ap dung voi tai khoan vang", 20.01, 60));
//        boolean test = dao.saveLoanRate(list);
//        assertEquals(t, test);
//    }
    
    @Test
    public void testSaveLoanRate() throws SQLException{
        boolean test = true;
        boolean kq = false;
        LoanTypeDAO dao = new LoanTypeDAO();
        ArrayList<LoanType> choseLoan = new ArrayList<>();
        choseLoan.add(new LoanType(1, "Vay tin chap", "ap dung voi tai khoan vang", 20.02, 60));
        Connection connection = dao.getDAOConnection();
        connection.setAutoCommit(false);
        try {
            kq = dao.saveLoanRate(choseLoan);
            connection.rollback();
        } catch (Exception e) {
            connection.rollback();
            connection.close();
        }
        assertEquals(kq, test);
    }


    //Check exist
    @Test
    public void testCheckExistLoan() {
        LoanTypeDAO dao = new LoanTypeDAO();
        boolean t = true;
        String s = "Vay tin chap";
        boolean test= dao.checkExistLoan(s);
        assertEquals(t, test);
    }
    //Check not exist
    @Test
    public void testCheckNotExistLoan() {
        LoanTypeDAO dao = new LoanTypeDAO();
        boolean t = false;
        String s = "Vay tin chap abc";
        boolean test= dao.checkExistLoan(s);
        assertEquals(t, test);
    }


    @Test
    public void testAddLoanType(){
         boolean test =true;
        Connection connection = new LoanTypeDAO().getDAOConnection();
        boolean kq = false;
        String insert = "INSERT INTO tblloantype(loan_name,rate,description,duration) VALUES (?,?,?,?)";
        ArrayList<LoanType> lt = new ArrayList<>();
        lt.add(new LoanType("Hello kitty", "1", 4.01, 30));
        try {
            connection.setAutoCommit(false);
            for (int i = 0; i < lt.size(); i++) {
                PreparedStatement ps = connection.prepareStatement(insert);
                ps.setString(1, lt.get(i).getName());
                ps.setDouble(2, lt.get(i).getRate());
                ps.setString(3, lt.get(i).getDescription());
                ps.setInt(4, lt.get(i).getDuration());
                ps.executeUpdate();
            }
            
            kq = true;
            connection.rollback();

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }
        assertEquals(kq, test);
        
    }

    
    
}

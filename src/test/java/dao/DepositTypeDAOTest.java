/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import java.util.ArrayList;
import model.DepositType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author ASUS
 */
public class DepositTypeDAOTest {
    
    public DepositTypeDAOTest() {
    }

    @Test
    public void testGetAllDepositType() {
        ArrayList<DepositType> test = new ArrayList<>();
        test.add(new DepositType(1, "Tiet kiem khong ky han", null, 200, 10000));
        test.add(new DepositType(2, "Tiet kiem co ky han", null, 3.75, 1));
        test.add(new DepositType(3, "Tiet kiem co ky han", null, 3.9, 3));
        test.add(new DepositType(4, "Tiet kiem co ky han", null, 5.5, 6));
        test.add(new DepositType(5, "Tiet kiem co ky han", null, 5.7, 9));
        test.add(new DepositType(6, "Tiet kiem co ky han", null, 6, 12));
        test.add(new DepositType(7, "Tiet kiem co ky han", null, 6.25, 18));
        test.add(new DepositType(8, "Tiet kiem co ky han", null, 6.35, 24));
        test.add(new DepositType(9, "Tiet kiem co ky han", null, 200, 36));
        
        
        DepositTypeDAO dao = new DepositTypeDAO();
        ArrayList<DepositType> res = dao.getAllDepositType();
        assertEquals(test, res);
    }

    @Test
    public void testSaveDepRate() {
        DepositTypeDAO dao = new DepositTypeDAO();
        boolean t =true;       
        ArrayList<DepositType> list = new ArrayList<>();
        list.add(new DepositType(3, "Tiet kiem co ky han", null, 3.9, 3));
        boolean test = dao.saveDepRate(list);
        assertEquals(t,test);
        
    }

    @Test
    public void testCheckExistDeposit() {
        DepositTypeDAO dao = new DepositTypeDAO();
        boolean t = true;
        String s = "Tiet kiem co ky han";
        boolean test = dao.checkExistDeposit(s);
        assertEquals(t, test);
    }
    @Test
    public void testCheckNotExistDeposit() {
        DepositTypeDAO dao = new DepositTypeDAO();
        boolean t = false;
        String s = "Tiet kiem ngay he";
        boolean test = dao.checkExistDeposit(s);
        assertEquals(t, test);
    }

//    @Test
//    public void testAddDepType() {
//        boolean t = true;
//        DepositTypeDAO dao = new DepositTypeDAO();
//        ArrayList<DepositType> list = new ArrayList<>();
//        list.add(new DepositType("Tiet kiem cho ho ngheo", null, 4, 3));
//        boolean test = dao.addDepType(list);
//        assertEquals(t, test);
//    }

    
    
}

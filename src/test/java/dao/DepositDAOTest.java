package dao;

import model.Deposit;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepositDAOTest {
    DepositDAO depositDAO = new DepositDAO();
    @Test
    //Test kịch bản chuẩn
    void getDeposit() throws SQLException {
        ArrayList<Deposit> listDeposits = depositDAO.getDeposit(1);
        assertEquals(depositDAO.getDeposit(1).toString(),listDeposits.toString());
    }
    // Test nếu số trang nhập vào <= 0
    // Kết quả trả về là null
    @Test
    void getDepositPageError() throws  SQLException{
        assertEquals(depositDAO.getDeposit(0),null);
        assertEquals(depositDAO.getDeposit(-1),null);
    }
    // Test kịch bản chuẩn
    @Test
    void getTotal() throws SQLException{
        int total = depositDAO.getTotal();
        assertEquals(depositDAO.getTotal(),total);
    }

    // Test kịch bản chuẩn
    @Test
    void getDepositDetail() throws SQLException{
        Deposit deposit = depositDAO.getDepositDetail(1);
        assertEquals(depositDAO.getDepositDetail(1).toString(), deposit.toString());
    }
    // Test khi nhập id ko có trong db sẽ trả về null
    @Test
    void getDepositDetailInvalidID() throws SQLException{
        assertEquals(depositDAO.getDepositDetail(12312),null);
    }
}
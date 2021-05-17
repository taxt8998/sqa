package dao;

import model.Deposit;
import model.Loan;
import model.LoanType;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LoanDAOTest {
    LoanDAO loanDAO = new LoanDAO();
    @Test
    // Test kịch bản chuẩn
    void getLoan() throws SQLException {
        ArrayList<Loan> listLoans = loanDAO.getLoan(1);
        assertEquals(loanDAO.getLoan(1).toString(),listLoans.toString());
    }
    @Test
    // Test nhập số trang <= 0
    void getLoanPageError() throws  SQLException{
        assertEquals(loanDAO.getLoan(0),null);
        assertEquals(loanDAO.getLoan(-1),null);
    }
    @Test
    // Test kịch bản chuẩn
    void getTotal() throws SQLException{
        int total = loanDAO.getTotal();
        assertEquals(loanDAO.getTotal(),total);
    }

    @Test
    // Test kịch bản chuẩn
    void getLoanDetail() throws SQLException{
        Loan loan = loanDAO.getLoanDetail(1);
        assertEquals(loanDAO.getLoanDetail(1).toString(), loan.toString());
    }

    // Test khi nhập id ko có trong db sẽ trả về null
    @Test
    void getDepositDetailInvalidID() throws SQLException{
        assertEquals(loanDAO.getLoanDetail(12312),null);
    }
}
package dao;

import model.Deposit;
import model.Loan;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReportDAOTest {
    ReportDAO reportDAO = new ReportDAO();
    @Test
    // Test kịch bản chuẩn
    void getMonthReportLoan() throws SQLException {
        ArrayList<Loan> listLoans = reportDAO.getMonthReportLoan(1,2020,1);
        assertEquals(reportDAO.getMonthReportLoan(1,2020,1).toString(),listLoans.toString());
    }

    @Test
    //Test kịch bản khi nhập số trang <= 0
    // Kết quả trả về là null
    void getMonthReportLoanPageError() throws SQLException{
        assertEquals(reportDAO.getMonthReportLoan(1,2020,0),null);
        assertEquals(reportDAO.getMonthReportLoan(1,2020,-1),null);
    }
    @Test
    // Test kịch bản khi tháng nhập không hợp lệ
    // Kết quả trả về là mảng rỗng
    void getMonthReportLoanMonthError() throws  SQLException{
        ArrayList<Loan> listLoans = new ArrayList<>();
        assertEquals(reportDAO.getMonthReportLoan(-1,2020,1),listLoans);
        assertEquals(reportDAO.getMonthReportLoan(20,2020,1),listLoans);
    }

    @Test
    // Test kịch bản khi năm nhập không hợp lệ
    // Kết quả trả về là mảng rỗng
    void getMonthReportLoanYearError() throws SQLException{
        ArrayList<Loan> listLoans = new ArrayList<>();
        assertEquals(reportDAO.getMonthReportLoan(1,0,1),listLoans);
        assertEquals(reportDAO.getMonthReportLoan(1,99999,1),listLoans);
    }

    @Test
    // Test kịch bản chuẩn
    void getYearReportLoan() throws SQLException{
        ArrayList<Loan> listLoans = reportDAO.getYearReportLoan(2020,1);
        assertEquals(reportDAO.getYearReportLoan(2020,1).toString(), listLoans.toString());
    }

    @Test
    // Test kịch bản nhập năm không hợp lệ
    // Kết quả trả về là mảng rỗng
    void getYearReportLoanYearError() throws SQLException{
        ArrayList<Loan> listLoans = new ArrayList<>();
        assertEquals(reportDAO.getYearReportLoan(0,1),listLoans);
        assertEquals(reportDAO.getYearReportLoan(-1,1),listLoans);
        assertEquals(reportDAO.getYearReportLoan(9999,1),listLoans);
    }

    @Test
    // Test kịch bản nhập số trang không hợp lệ
    // Kết quả trả về là null
    void getYearReportLoanPageError() throws SQLException{
        assertEquals(reportDAO.getYearReportLoan(2020,0),null);
        assertEquals(reportDAO.getYearReportLoan(2020,-1),null);
    }
    @Test
    // Test kịch bản chuẩn
    void getQuarterReportLoan() throws  SQLException,Exception{
        ArrayList<Loan> listLoans = reportDAO.getQuarterReportLoan(1,2020,1);
        assertEquals(reportDAO.getQuarterReportLoan(1,2020,1).toString(),listLoans.toString());
    }

    @Test
    // Test Kịch bản nhập quý không hợp lệ
    // kết quả trả về Exception("Quý ko hợp lê")
    void getQuarterReportLoanQuarterError() throws SQLException,Exception{
        try {
            reportDAO.getQuarterReportLoan(5,2020,1);
            fail("Not throw exception");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Quý ko hợp lệ");
        }
    }

    @Test
    // Test kịch bản nhập vào số năm không hộp lệ
    // Kết quả trả về mảng rỗng
    void getQuarterReportLoanYearError() throws SQLException,Exception{
        ArrayList<Loan> listLoans = new ArrayList<>();
        assertEquals(reportDAO.getQuarterReportLoan(3,0,1),listLoans);
    }

    @Test
    // Test kịch bản nhập vào số trang không hợp lệ
    // Kết quả trả về null
    void getQuarterReportLoanPageError() throws  SQLException,Exception{
        assertEquals(reportDAO.getQuarterReportLoan(3,2020,-1),null);
    }

    @Test
    // Test kịch bản chuẩn
    void getMonthQuantity() throws SQLException{
        int total = reportDAO.getMonthQuantity(2,2020);
        assertEquals(reportDAO.getMonthQuantity(2,2020),total);
    }

    @Test
    // Test kịch bản nhập tháng không hợp lệ
    // Kết quả trả về 0
    void getMonthQuantityMonthError() throws SQLException{
        assertEquals(reportDAO.getMonthQuantity(-1,2020),0);
    }

    @Test
    // Test kịch bản năm nhập không hợp lệ
    // Kết quả trả về 0
    void getMonthQuantityYearError() throws  SQLException{
        assertEquals(reportDAO.getMonthQuantity(2,-202),0);
    }

    @Test
    // Test kịch bản chuẩn
    void getQuarterQuantity() throws SQLException, Exception{
        int total = reportDAO.getQuarterQuantity(2,2020);
        assertEquals(reportDAO.getQuarterQuantity(2,2020),total);
    }

    @Test
    // Test kịch bản nhập quý không hợp lệ
    // Kết quả trả về Exception("Quý ko hợp lệ")
    void getQuarterQuantityQuarterError() throws  Exception{
        try {
            int total = reportDAO.getQuarterQuantity(5,2020);
            fail("Not throw Exception");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Quý ko hợp lệ");
        }
    }

    @Test
    // Test kịch bản nhập năm không hợp lệ
    // Kết quả trâ về 0
    void getQuarterQuantityYearError() throws Exception{
        assertEquals(reportDAO.getQuarterQuantity(2,-2230),0);
    }

    @Test
    // Test kịch bản chuẩn
    void getYearQuantity() throws  SQLException{
        int total = reportDAO.getYearQuantity(2020);
        assertEquals(reportDAO.getYearQuantity(2020),total);
    }

    @Test
    // Test kịch bản nhập năm không hợp lệ
    // Kết quả trả về 0
    void getYearQuantityYearError() throws SQLException{
        assertEquals(reportDAO.getYearQuantity(-2020),0);
    }

    @Test
    // Test kịch bản chuẩn
    void getMonthTotal() throws SQLException{
        double total = reportDAO.getMonthTotal(1,2020);
        assertEquals(reportDAO.getMonthTotal(1,2020),total);
    }

    @Test
    // Test kịch bản nhập tháng không hợp lệ
    // Kết quả trả vể 0
    void getMonthTotalMonthError() throws SQLException{
        assertEquals(reportDAO.getMonthTotal(-1,2020),0);
    }

    @Test
    // Test kịch bản năm nhập không hợp lệ
    // Kết quả trả về 0
    void getMonthTotalYearError() throws SQLException{
        assertEquals(reportDAO.getMonthTotal(1,-2020),0);
    }

    @Test
    // Test kịch bản chuẩn
    void getQuarterTotal() throws Exception{
        double total = reportDAO.getQuarterTotal(1,2020);
        assertEquals(reportDAO.getQuarterTotal(1,2020),total);
    }

    @Test
    // Test kịch bản nhập quý không hợp lệ
    // Kết quả trả về Exception("Quý ko hợp lệ")

    void getQuarterTotalQuarterError() throws Exception{
        try {
            reportDAO.getQuarterTotal(5,2020);
            fail("Not throw Exception");
        }
        catch (Exception e) {
            assertEquals(e.getMessage(),"Quý ko hợp lệ");
        }
    }

    @Test
    // Test kịch bản nhập năm không hợp lệ
    // Kết quả trả về 0
    void getQuarterTotalYearError() throws Exception{
        assertEquals(reportDAO.getQuarterTotal(1,-2020),0);
    }

    @Test
    // Test kịch bản chuẩn
    void getYearTotal() throws SQLException{
        double total = reportDAO.getYearTotal(2020);
        assertEquals(reportDAO.getYearTotal(2020),total);
    }

    @Test
    // Test kịch bản nhập năm không hợp lệ
    // Kết quả trả về 0
    void getYearTotalYearError() throws SQLException{
        assertEquals(reportDAO.getYearTotal(-2020),0);
    }
    @Test
    // Test kịch bản chuẩn
    void getMonthReportDeposit() throws SQLException {
        ArrayList<Deposit> listDeposits = reportDAO.getMonthReportDeposit(1,2020,1);
        assertEquals(reportDAO.getMonthReportDeposit(1,2020,1).toString(),listDeposits.toString());
    }

    @Test
        //Test kịch bản khi nhập số trang <= 0
        // Kết quả trả về là null
    void getMonthReportDepositPageError() throws SQLException{
        assertEquals(reportDAO.getMonthReportDeposit(1,2020,0),null);
        assertEquals(reportDAO.getMonthReportDeposit(1,2020,-1),null);
    }
    @Test
        // Test kịch bản khi tháng nhập không hợp lệ
        // Kết quả trả về là mảng rỗng
    void getMonthReportDepositMonthError() throws  SQLException{
        ArrayList<Deposit> listDeposits = new ArrayList<>();
        assertEquals(reportDAO.getMonthReportDeposit(-1,2020,1),listDeposits);
        assertEquals(reportDAO.getMonthReportDeposit(20,2020,1),listDeposits);
    }

    @Test
        // Test kịch bản khi năm nhập không hợp lệ
        // Kết quả trả về là mảng rỗng
    void getMonthReportDepositYearError() throws SQLException{
        ArrayList<Deposit> listDeposits = new ArrayList<>();
        assertEquals(reportDAO.getMonthReportDeposit(1,0,1),listDeposits);
        assertEquals(reportDAO.getMonthReportDeposit(1,99999,1),listDeposits);
    }
    @Test
        // Test kịch bản chuẩn
    void getYearReportDeposit() throws SQLException{
        ArrayList<Deposit> listDeposits = reportDAO.getYearReportDeposit(2020,1);
        assertEquals(reportDAO.getYearReportDeposit(2020,1).toString(), listDeposits.toString());
    }

    @Test
        // Test kịch bản nhập năm không hợp lệ
        // Kết quả trả về là mảng rỗng
    void getYearReportDepositYearError() throws SQLException{
        ArrayList<Deposit> listDeposits = new ArrayList<>();
        assertEquals(reportDAO.getYearReportDeposit(0,1),listDeposits);
        assertEquals(reportDAO.getYearReportDeposit(-1,1),listDeposits);
        assertEquals(reportDAO.getYearReportDeposit(9999,1),listDeposits);
    }

    @Test
        // Test kịch bản nhập số trang không hợp lệ
        // Kết quả trả về là null
    void getYearReportDepositPageError() throws SQLException{
        assertEquals(reportDAO.getYearReportDeposit(2020,0),null);
        assertEquals(reportDAO.getYearReportDeposit(2020,-1),null);
    }
    @Test
        // Test kịch bản chuẩn
    void getQuarterReportDeposit() throws  SQLException,Exception{
        ArrayList<Deposit> listDeposits = reportDAO.getQuarterReportDeposit(1,2020,1);
        assertEquals(reportDAO.getQuarterReportDeposit(1,2020,1).toString(),listDeposits.toString());
    }

    @Test
        // Test Kịch bản nhập quý không hợp lệ
        // kết quả trả về Exception("Quý ko hợp lê")
    void getQuarterReportDepositQuarterError() throws SQLException,Exception{
        try {
            reportDAO.getQuarterReportDeposit(5,2020,1);
            fail("Not throw exception");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Quý ko hợp lệ");
        }
    }

    @Test
        // Test kịch bản nhập vào số năm không hộp lệ
        // Kết quả trả về mảng rỗng
    void getQuarterReportDepositYearError() throws SQLException,Exception{
        ArrayList<Deposit> listDeposits = new ArrayList<>();
        assertEquals(reportDAO.getQuarterReportDeposit(3,0,1),listDeposits);
    }

    @Test
        // Test kịch bản nhập vào số trang không hợp lệ
        // Kết quả trả về null
    void getQuarterReportDepositPageError() throws  SQLException,Exception{
        assertEquals(reportDAO.getQuarterReportDeposit(3,2020,-1),null);
    }

    @Test
        // Test kịch bản chuẩn
    void getMonthQuantityDeposit() throws SQLException{
        int total = reportDAO.getMonthQuantityDeposit(2,2020);
        assertEquals(reportDAO.getMonthQuantityDeposit(2,2020),total);
    }

    @Test
        // Test kịch bản nhập tháng không hợp lệ
        // Kết quả trả về 0
    void getMonthQuantityDepositMonthError() throws SQLException{
        assertEquals(reportDAO.getMonthQuantityDeposit(-1,2020),0);
    }

    @Test
        // Test kịch bản năm nhập không hợp lệ
        // Kết quả trả về 0
    void getMonthQuantityDepositYearError() throws  SQLException{
        assertEquals(reportDAO.getMonthQuantityDeposit(2,-202),0);
    }

    @Test
        // Test kịch bản chuẩn
    void getQuarterQuantityDeposit() throws SQLException, Exception{
        int total = reportDAO.getQuarterQuantityDeposit(2,2020);
        assertEquals(reportDAO.getQuarterQuantityDeposit(2,2020),total);
    }

    @Test
        // Test kịch bản nhập quý không hợp lệ
        // Kết quả trả về Exception("Quý ko hợp lệ")
    void getQuarterQuantityDepositQuarterError() throws  Exception{
        try {
            int total = reportDAO.getQuarterQuantityDeposit(5,2020);
            fail("Not throw Exception");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Quý ko hợp lệ");
        }
    }

    @Test
        // Test kịch bản nhập năm không hợp lệ
        // Kết quả trâ về 0
    void getQuarterQuantityDepositYearError() throws Exception{
        assertEquals(reportDAO.getQuarterQuantityDeposit(2,-2230),0);
    }

    @Test
        // Test kịch bản chuẩn
    void getYearQuantityDeposit() throws  SQLException{
        int total = reportDAO.getYearQuantityDeposit(2020);
        assertEquals(reportDAO.getYearQuantityDeposit(2020),total);
    }

    @Test
        // Test kịch bản nhập năm không hợp lệ
        // Kết quả trả về 0
    void getYearQuantityDepositYearError() throws SQLException{
        assertEquals(reportDAO.getYearQuantityDeposit(-2020),0);
    }

    @Test
        // Test kịch bản chuẩn
    void getMonthTotalDeposit() throws SQLException{
        double total = reportDAO.getMonthTotalDeposit(1,2020);
        assertEquals(reportDAO.getMonthTotalDeposit(1,2020),total);
    }

    @Test
        // Test kịch bản nhập tháng không hợp lệ
        // Kết quả trả vể 0
    void getMonthTotalDepositMonthError() throws SQLException{
        assertEquals(reportDAO.getMonthTotalDeposit(-1,2020),0);
    }

    @Test
        // Test kịch bản năm nhập không hợp lệ
        // Kết quả trả về 0
    void getMonthTotalDepositYearError() throws SQLException{
        assertEquals(reportDAO.getMonthTotalDeposit(1,-2020),0);
    }

    @Test
        // Test kịch bản chuẩn
    void getQuarterTotalDeposit() throws Exception{
        double total = reportDAO.getQuarterTotalDeposit(1,2020);
        assertEquals(reportDAO.getQuarterTotalDeposit(1,2020),total);
    }

    @Test
        // Test kịch bản nhập quý không hợp lệ
        // Kết quả trả về Exception("Quý ko hợp lệ")

    void getQuarterTotalDepositQuarterError() throws Exception{
        try {
            reportDAO.getQuarterTotalDeposit(5,2020);
            fail("Not throw Exception");
        }
        catch (Exception e) {
            assertEquals(e.getMessage(),"Quý ko hợp lệ");
        }
    }

    @Test
        // Test kịch bản nhập năm không hợp lệ
        // Kết quả trả về 0
    void getQuarterTotalDepositYearError() throws Exception{
        assertEquals(reportDAO.getQuarterTotalDeposit(1,-2020),0);
    }

    @Test
        // Test kịch bản chuẩn
    void getYearTotalDeposit() throws SQLException{
        double total = reportDAO.getYearTotalDeposit(2020);
        assertEquals(reportDAO.getYearTotalDeposit(2020),total);
    }

    @Test
        // Test kịch bản nhập năm không hợp lệ
        // Kết quả trả về 0
    void getYearTotalDepositYearError() throws SQLException{
        assertEquals(reportDAO.getYearTotalDeposit(-2020),0);
    }

}
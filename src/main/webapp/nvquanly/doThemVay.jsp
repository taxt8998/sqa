<%-- 
    Document   : doThemVay
    Created on : Mar 23, 2021, 9:02:44 AM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đang thêm mới</title>
    </head>
    <body>
        <%
            ArrayList<LoanType> listLoan = new ArrayList<>();
            String raw_loanname = request.getParameter("l_name");
            raw_loanname = raw_loanname.toLowerCase().trim().replaceAll("\\s+", " ");
            String loan_name = raw_loanname.substring(0, 1).toUpperCase() + raw_loanname.substring(1);
            
            double rate_gold = Double.parseDouble(request.getParameter("rate_gold"));
            int duration_gold = Integer.parseInt(request.getParameter("duration_gold"));
            double rate_silver = Double.parseDouble(request.getParameter("rate_silver"));
            int duration_silver = Integer.parseInt(request.getParameter("duration_silver"));
            double rate_bronze = Double.parseDouble(request.getParameter("rate_bronze"));
            int duration_bronze = Integer.parseInt(request.getParameter("duration_bronze"));
            String des_gold = "ap dung voi tai khoan vang";
            String des_silver = "ap dung voi tai khoan bac";
            String des_bronze = "ap dung voi tai khoan dong";

            LoanType lt_gold = new LoanType(loan_name, des_gold, rate_gold, duration_gold);
            LoanType lt_silver = new LoanType(loan_name, des_silver, rate_silver, duration_silver);
            LoanType lt_bronze = new LoanType(loan_name, des_bronze, rate_bronze, duration_bronze);

            listLoan.add(lt_gold);
            listLoan.add(lt_silver);
            listLoan.add(lt_bronze);

            LoanTypeDAO dao = new LoanTypeDAO();
            if (!dao.checkExistLoan(loan_name)) {
                //thuc hien luu
                boolean kq = dao.addLoanType(listLoan);
                if (kq) {
        %>
        <script type="text/javascript">
            alert("Thêm mới kiểu vay thành công !!!");
            window.location = "gdCauhinh.jsp";
        </script>
        <%      }else{
        %>
        <script type="text/javascript">
            alert("Lỗi thêm mới !!!");
            history.back();
        </script>     
        <%              
                }
            } else {
                //da ton tai
        %>
        <script type="text/javascript">
            alert("Loại vay này đã tồn tại trong Cơ sở dữ liệu !!!");
            history.back();
        </script>       
        <%
            }
        %>
    </body>
</html>

<%-- 
    Document   : gdXoachitietvay
    Created on : Mar 24, 2021, 8:19:55 AM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đang xóa</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("../index.jsp");
            }
        %>
        <%
            String kieuvayxoa = request.getParameter("kieuvayxoa");
            ArrayList<LoanType> listLoan = (ArrayList<LoanType>) session.getAttribute("listLoan");
            LoanType dt = new LoanType();
            for (int i = 0; i < listLoan.size(); i++) {
                if (listLoan.get(i).getName().equalsIgnoreCase(kieuvayxoa)) {
                    dt.setId(listLoan.get(i).getId());
                    dt.setName(listLoan.get(i).getName());
                    dt.setRate(listLoan.get(i).getRate());
                    dt.setDuration(listLoan.get(i).getDuration());
                    dt.setDescription(listLoan.get(i).getDescription());
                }
            }
            boolean kq = (new LoanTypeDAO()).deleteLoan(dt);
            if (kq) {
        %>
        <script type="text/javascript">
            alert("Xóa thành công");
            window.location = "gdCauhinh.jsp";
        </script>
        <%
        } else {
        %>
        <script type="text/javascript">
            alert("Lỗi xóa!");
            history.back();
        </script>
        <%
            }
        %>
    </body>
</html>

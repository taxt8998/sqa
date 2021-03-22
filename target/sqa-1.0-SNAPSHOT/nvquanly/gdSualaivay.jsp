<%-- 
    Document   : gdSualaivay
    Created on : Mar 22, 2021, 3:05:42 PM
    Author     : ASUS
--%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Chọn kiểu vay</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("home.jsp");
            }
        %>
        <%
            ArrayList<LoanType> listLoan = (new LoanTypeDAO()).getAllLoanType();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < listLoan.size(); i++) {
                set.add(listLoan.get(i).getName());
            }
            session.setAttribute("listLoan", listLoan);
        %>
        <form action="gdSuachitietvay.jsp">
            <select id="kieuvay" name="kieuvay">
                <% for (String s : set) {%>
                <option><%=s%> </option>
                <%}%>
            </select>
            <input type="submit" value="Sửa">
        </form>
    </body>
</html>

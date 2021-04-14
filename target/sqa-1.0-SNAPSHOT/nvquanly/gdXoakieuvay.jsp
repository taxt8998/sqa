<%-- 
    Document   : gdXoakieuvay
    Created on : Mar 24, 2021, 8:16:59 AM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Xóa kiểu vay</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("../index.jsp");
        %>
        <%
            ArrayList<LoanType> listLoan = (new LoanTypeDAO()).getAllLoanType();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < listLoan.size(); i++) {
                set.add(listLoan.get(i).getName());
            }
            session.setAttribute("listLoan", listLoan);
        %>
         <form action="gdXoachitietvay.jsp">
            <select id="kieuvayxoa" name="kieuvayxoa">
                <% for (String s : set) {%>
                <option><%=s%> </option>
                <%}%>
            </select>
            <input type="submit" value="Xóa"  onclick="return confirm('Bạn có chắc muốn xóa?')">
        </form>
    </body>
</html>

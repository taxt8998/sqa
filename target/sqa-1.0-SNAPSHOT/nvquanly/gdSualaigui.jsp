<%-- 
    Document   : gdSualaigui
    Created on : Mar 22, 2021, 3:33:53 PM
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
        <title>Chọn kiểu gửi</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("home.jsp");
        %>
        <%
            ArrayList<DepositType> listDep = (new DepositTypeDAO()).getAllDepositType();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < listDep.size(); i++) {
                set.add(listDep.get(i).getName());
            }
            session.setAttribute("listDep", listDep);
        %>
        <form action="gdSuachitietgui.jsp">
            <select id="kieugui" name="kieugui">
                <% for (String s : set) {%>
                <option><%=s%> </option>
                <%}%>
            </select>
            <input type="submit" value="Sửa">
        </form>
    </body>
</html>

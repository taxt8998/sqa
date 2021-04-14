<%-- 
    Document   : gdXoakieugui
    Created on : Mar 24, 2021, 9:26:39 AM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Xóa kiểu gửi</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("../index.jsp");
        %>
        <%
            ArrayList<DepositType> listDep = (new DepositTypeDAO()).getAllDepositType();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < listDep.size(); i++) {
                set.add(listDep.get(i).getName());
            }
            session.setAttribute("listDep", listDep);
        %>
        <form action="gdXoachitietgui.jsp">
            <select id="kieuguixoa" name="kieuguixoa">
                <% for (String s : set) {%>
                <option><%=s%> </option>
                <%}%>
            </select>
            <input type="submit" value="Xóa"  onclick="return confirm('Bạn có chắc muốn xóa?')">
        </form>
    </body>
</html>

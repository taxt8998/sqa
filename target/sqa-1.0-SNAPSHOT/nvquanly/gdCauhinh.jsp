<%-- 
    Document   : gdCauhinh
    Created on : Mar 19, 2021, 10:02:05 PM
    Author     : ASUS
--%>
<%@page import="java.util.*,dao.*,model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Giao diện cấu hình</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("home.jsp");
        %>
        <div>
            <button  onclick="openPage('gdCauhinhVay.jsp')">Cấu hình vay</button>
            <button  onclick="openPage('gdCauhinhGui.jsp')">Cấu hình gửi</button>
	</div>
    </body>
</html>

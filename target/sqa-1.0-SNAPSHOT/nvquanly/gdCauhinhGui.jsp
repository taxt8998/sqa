<%-- 
    Document   : gdCauhinhGui
    Created on : Mar 22, 2021, 3:30:57 PM
    Author     : ASUS
--%>
<%@page import="model.Employee"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Cấu hình gửi</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("home.jsp");
        %>
        <button  onclick="openPage('gdThemkieugui.jsp')">Thêm kiểu gửi</button>
        <button  onclick="openPage('gdSualaigui.jsp')">Sửa lãi gửi</button>
        <button  onclick="openPage('gdXoakieugui.jsp')">Xóa kiểu gửi</button>
    </body>
</html>

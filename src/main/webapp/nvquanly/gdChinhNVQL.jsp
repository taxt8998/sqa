<%-- 
    Document   : gdChinhNVQL
    Created on : Mar 19, 2021, 9:23:53 PM
    Author     : ASUS
--%>
<%@ page import="java.util.ArrayList,dao.*,model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Giao diện nhân viên quản lý</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("../index.jsp");
        %>
        <div>
            <h4>Chào bạn, Nhân viên quản lý !</h4>
            <button  onclick="openPage('gdTheoDoiDS.jsp')">Theo dõi danh sách</button>
            <button  onclick="openPage('gdChonLoaiBaoCao.jsp')">Xuất báo cáo</button>
            <button  onclick="openPage('gdCauhinh.jsp')">Cấu hình</button>
        </div>
    </body>
</html>

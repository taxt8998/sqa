<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/22/2021
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee emp = (Employee) session.getAttribute("user");
    if(emp == null) response.sendRedirect("../index.jsp");
%>
<html>
<head>
    <title>Chọn loại giao dịch</title>

    <%@include file ="../header.jsp" %>
</head>
<body>
    <h3>Chọn loại giao dịch</h3>
    <button  onclick="openPage('gdTheoDoiVay.jsp')">Khoản vay</button>
    <button  onclick="openPage('gdTheoDoiTK.jsp')">Khoản tiết kiệm</button>
</body>
</html>

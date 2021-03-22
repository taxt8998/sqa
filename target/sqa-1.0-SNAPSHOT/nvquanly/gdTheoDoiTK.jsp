<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/22/2021
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee emp = (Employee) session.getAttribute("user");
    if(emp == null) response.sendRedirect("index.jsp");
%>
<html>
<head>
    <title>Theo dõi khoản vay</title>
</head>
<body>
    <h3>Theo dõi khoản vay</h3>
    <table>
        <thead>
            <td>STT</td>
            <td>Chủ tài khoản</td>
            <td>Số tài khoản</td>
            <td>Số tiền</td>
            <td>Ngày gửi</td>
        </thead>
        <tr></tr>
    </table>
</body>
</html>

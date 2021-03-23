<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/15/2021
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee employee = (Employee) session.getAttribute("user");
    if (employee != null) {
        response.sendRedirect("home.jsp");
        return;
    }
%>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <table>

        <form action="doDangnhap.jsp" method="post" name="login" id="login">
            <tr>
                <td><label for="">Tên đăng nhập</label></td>
                <td><input type="text" id="username" name="username" autofocus="autofocus"></td>
            </tr>
            <tr>
                <td><label for="">Mật khẩu</label></td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit" form="login">Đăng nhập</button></td>
            </tr>
        </form>
    </table>
</body>
</html>

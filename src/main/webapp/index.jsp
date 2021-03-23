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
        response.sendRedirect("nvquanly/gdChinhNVQL.jsp");
        return;
    }
    int errorCode = 0;
    if(request.getParameter("error") != null) errorCode = Integer.parseInt(request.getParameter("error")) ;

%>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <table>

        <form action="doDangnhap.jsp" method="post" name="login" id="login">
            <tr>
                <td><label>Tên đăng nhập</label></td>
                <td><input
                        type="text"
                        id="username"
                    <% if (errorCode == 3) {%> autofocus <%}%>
                        name="username"
                    <% if (errorCode == 2) {%> value="<%=session.getAttribute("username")%>" <%}%>>
                </td>
            </tr>
            <%if (errorCode == 3){%>
            <tr>
                <td></td>
                <td><p style="color: #ff0000"> Tên đăng nhập không tồn tại</p></td>
            </tr>
            <%}%>
            <tr>
                <td><label for=>Mật khẩu</label></td>
                <td><input type="password" name="password" <% if (errorCode == 2) {%> autofocus <%}%>  id="password"></td>
            </tr>
            <%if (errorCode == 2){%>
            <tr>
                <td></td>
                <td><p style="color: #ff0000"> Sai mật khẩu</p></td>
            </tr>
            <%}%>
            <tr>
                <td></td>
                <td><button type="submit" form="login">Đăng nhập</button></td>
            </tr>
        </form>
    </table>
</body>
</html>

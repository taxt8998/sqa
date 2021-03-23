<%@ page import="dao.EmployeeDAO" %>
<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/19/2021
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    EmployeeDAO empDAO = new EmployeeDAO();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    session.setAttribute("username",username);
    session.setAttribute("password",password);
    Employee emp = new Employee();
    emp.setUsername(username);
    emp.setPassword(password);
    int kq = empDAO.checkLogin(emp);
    if(kq == 1 && emp.getPosition().equalsIgnoreCase("manager")){
        session.setAttribute("user",emp);
        response.sendRedirect("nvquanly/gdChinhNVQL.jsp");
    }

    // Sai mật khẩu
    else if (kq == 2 ) { %>
        <form action="index.jsp" method="post" name="error" id="error">
        <input type="hidden" value="2" name="error">
        </form>
<%
    }
    // Sai tên đăng nhập
    else if (kq == 3) { %>
        <form action="index.jsp" method="post" name="error" id="error">
        <input type="hidden" value="3" name="error">
        </form>
<%
    }

%>
<html>
<head>
    <script type="text/javascript">

        function formAutoSubmit () {

            var frm = document.getElementById("error");

            frm.submit();

        }

        window.onload = formAutoSubmit;

    </script>
</head>
<body>

</body>
</html>
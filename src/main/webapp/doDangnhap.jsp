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
    Employee emp = new Employee();
    emp.setUsername(username);
    emp.setPassword(password);
    boolean kq = empDAO.checkLogin(emp);
    System.out.println(kq);
    if(kq && emp.getPosition().equalsIgnoreCase("manager")){
        session.setAttribute("user",emp);
        response.sendRedirect("home.jsp");
    }
    else {
        response.sendRedirect("index.jsp");
    }

%>
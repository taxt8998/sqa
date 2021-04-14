<%@ page import="model.Employee" %>
<%@ page import="model.Loan" %>
<%@ page import="dao.LoanDAO" %>
<%@ page import="utils.FormatDate" %>
<%@ page import="utils.FormatDecimal" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="dao.DepositDAO" %>
<%@ page import="model.Deposit" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/23/2021
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Employee emp = (Employee) session.getAttribute("user");
    if(emp == null) response.sendRedirect("../index.jsp");
    String idx = request.getParameter("id");
%>
<%
    if (Pattern.matches("[0-9]",idx)) {
        int id = Integer.parseInt(idx);
        FormatDate formatDate = new FormatDate();
        FormatDecimal formatDecimal = new FormatDecimal();
        DepositDAO depositDAO = new DepositDAO();
        Deposit deposit = depositDAO.getDepositDetail(id);
        if (deposit != null){

%>
<html>
<head>
    <title>Chi tiết khoản tiết kiệm</title>
    <%@include file ="../header.jsp" %>
</head>
<body>
<table>
    <tr>
        <td>Chủ tài khoản</td>
        <td><%=deposit.getAccount().getCustomer().getName()%></td>
    </tr>
    <tr>
        <td>Số tài khoản</td>
        <td><%=deposit.getAccount().getId()%></td>
    </tr>
    <tr>
        <td>Số tiền tiết kiệm</td>
        <td><%=formatDecimal.formatCurrency(deposit.getAmount())%></td>
    </tr>
    <tr>
        <td>Ngày gửi</td>
        <td><%=formatDate.format(deposit.getDepositDate())%></td>
    </tr>
    <tr>
        <td>Ngày kết thúc</td>
        <td><%=formatDate.format(deposit.getWithdraw_date())%></td>
    </tr>
    <tr>
        <td>Lãi suất</td>
        <td><%=deposit.getCurRate()%></td>
    </tr>
    <tr>
        <td>Tiền lãi</td>
        <td><%=formatDecimal.formatCurrency(deposit.getCurRate()/12 * deposit.getDuration() * deposit.getAmount() /100)%></td>
    </tr>
    <tr>
        <td>Tổng tiền</td>
        <td><%=formatDecimal.formatCurrency(deposit.getAmount() + (deposit.getCurRate()/12 * deposit.getDuration() * deposit.getAmount() /100 ))%></td>
    </tr>
    <tr>
        <td></td>
        <td><a href="gdTheoDoiTK.jsp">Quay lai</a></td>
    </tr>
</table>
</body>
</html>
<%
        }

        else {
            response.sendRedirect("gdTheoDoiVay.jsp");
        }
    }
    else {
        response.sendRedirect("gdTheoDoiVay.jsp");
    }
%>
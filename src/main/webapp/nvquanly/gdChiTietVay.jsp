<%@ page import="model.Employee" %>
<%@ page import="model.Loan" %>
<%@ page import="dao.LoanDAO" %>
<%@ page import="utils.FormatDate" %>
<%@ page import="utils.FormatDecimal" %>
<%@ page import="java.util.regex.Pattern" %><%--
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
        LoanDAO loanDAO = new LoanDAO();
        Loan loan = loanDAO.getLoanDetail(id);
        if (loan != null){

%>
<html>
<head>
    <title>Chi tiết khoản vay</title>
    <%@include file ="../header.jsp" %>
</head>
<body>
    <table>
        <tr>
            <td>Chủ tài khoản</td>
            <td><%=loan.getAccount().getCustomer().getName()%></td>
        </tr>
        <tr>
            <td>Số tài khoản</td>
            <td><%=loan.getAccount().getId()%></td>
        </tr>
        <tr>
            <td>Số tiền vay</td>
            <td><%=formatDecimal.formatCurrency(loan.getAmount())%></td>
        </tr>
        <tr>
            <td>Ngày vay</td>
            <td><%=formatDate.format(loan.getStartDate())%></td>
        </tr>
        <tr>
            <td>Ngày trả</td>
            <td><%=formatDate.format(loan.getEndDate())%></td>
        </tr>
        <tr>
            <td>Lãi suất</td>
            <td><%=loan.getCurRate()%></td>
        </tr>
        <tr>
            <td>Tiền lãi</td>
            <td><%=formatDecimal.formatCurrency(loan.getCurRate()/12 * loan.getDuration() * loan.getAmount() /100)%></td>
        </tr>
        <tr>
            <td>Tiền phải trả</td>
            <td><%=formatDecimal.formatCurrency(loan.getAmount() + (loan.getCurRate()/12 * loan.getDuration() * loan.getAmount() /100 ))%></td>
        </tr>
        <tr>
            <td></td>
            <td><a href="gdTheoDoiVay.jsp">Quay lai</a></td>
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
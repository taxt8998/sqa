<%@ page import="model.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Loan" %>
<%@ page import="dao.LoanDAO" %>
<%@ page import="utils.FormatDate" %>
<%@ page import="utils.FormatDecimal" %><%--
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


    FormatDate formatDate = new FormatDate();
    FormatDecimal formatDecimal = new FormatDecimal();
    LoanDAO loanDAO = new LoanDAO();
    String thisURL = String.valueOf(request.getRequestURL());
    System.out.println(thisURL);
    int total = loanDAO.getTotal();
    int quantity = 10;
    int maxPage =(int) Math.ceil((double) total/quantity);
    int pageNum ;
    try {
        pageNum = Integer.parseInt(request.getParameter("page"));
    } catch (Exception e){
        pageNum = 1;
    }
    if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
    ArrayList<Loan> listLoan = loanDAO.getLoan(pageNum);
%>
<html>
<head>
    <title>Theo dõi khoản vay</title>
    <%@include file ="../header.jsp" %>
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
    <tbody>
        <%for (int i =0 ;i<listLoan.size();i++){
            Loan loan = listLoan.get(i);
        %>
        <tr>
            <td><%=(pageNum -1) * quantity + i+1%></td>
            <td><%=loan.getAccount().getCustomer().getName()%></td>
            <td><%=loan.getAccount().getId()%></td>
            <td><%=formatDecimal.formatCurrency(loan.getAmount())%></td>
            <td><%=formatDate.format(loan.getStartDate())%></td>
        </tr>
        <%}%>
    </tbody>
</table>

<div class="pagination">
    <%if (pageNum > 1){%>
    <button onclick="openPage('gdTheoDoiVay.jsp?page=<%=pageNum-1%>')"><%=pageNum-1%></button>
    <%}%>
    <button onclick="openPage(<%=thisURL%>)" disabled ><%=pageNum%></button>
    <%if (pageNum<maxPage){%>
    <button onclick="openPage('gdTheoDoiVay.jsp?page=<%=pageNum+1%>')"><%=pageNum+1%></button>
    <%}%>
</div>
</body>
</html>

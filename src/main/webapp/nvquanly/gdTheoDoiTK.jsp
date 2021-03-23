<%@ page import="model.Employee" %>
<%@ page import="utils.FormatDecimal" %>
<%@ page import="utils.FormatDate" %>
<%@ page import="dao.DepositDAO" %>
<%@ page import="model.Deposit" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/22/2021
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Employee emp = (Employee) session.getAttribute("user");
    if(emp == null) response.sendRedirect("../index.jsp");


    FormatDate formatDate = new FormatDate();
    FormatDecimal formatDecimal = new FormatDecimal();
    DepositDAO depositDAO = new DepositDAO();
    String thisURL = String.valueOf(request.getRequestURL());
    int total = depositDAO.getTotal();
    int quantity = 10;
    int maxPage =(int) Math.ceil((double) total/quantity);
    int pageNum ;
    try {
        pageNum = Integer.parseInt(request.getParameter("page"));
    } catch (Exception e){
        pageNum = 1;
    }
    if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
    ArrayList<Deposit> listDeposit = depositDAO.getDeposit(pageNum);
%>
<html>
<head>
    <title>Theo dõi khoản tiết kiệm</title>
    <%@include file ="../header.jsp" %>
</head>
<body>
<h3>Theo dõi khoản tiết kiệm</h3>
<table>
    <thead>
    <td>STT</td>
    <td>Chủ tài khoản</td>
    <td>Số tài khoản</td>
    <td>Số tiền</td>
    <td>Ngày gửi</td>
    <td></td>
    </thead>
    <tbody>
    <%for (int i =0 ;i<listDeposit.size();i++){
        Deposit deposit = listDeposit.get(i);
    %>
    <tr>
        <td><%=(pageNum -1) * quantity + i+1%></td>
        <td><%=deposit.getAccount().getCustomer().getName()%></td>
        <td><%=deposit.getAccount().getId()%></td>
        <td><%=formatDecimal.formatCurrency(deposit.getAmount())%></td>
        <td><%=formatDate.format(deposit.getDepositDate())%></td>
        <td><a href="gdChiTietTK.jsp?id=<%=deposit.getId()%>">Xem thêm</a></td>
    </tr>
    <%}%>
    </tbody>
</table>

<div class="pagination">
    <%if (pageNum > 2){%>
    <button onclick="openPage('gdTheoDoiVay.jsp?page=<%=1%>')">Trang đầu</button>
    <%}%>
    <%if (pageNum > 1){%>
    <button onclick="openPage('gdTheoDoiVay.jsp?page=<%=pageNum-1%>')"><%=pageNum-1%></button>
    <%}%>
    <button onclick="openPage(<%=thisURL%>)" disabled ><%=pageNum%></button>
    <%if (pageNum < maxPage){%>
    <button onclick="openPage('gdTheoDoiVay.jsp?page=<%=pageNum+1%>')"><%=pageNum+1%></button>
    <%}%>
    <%if (pageNum < maxPage - 1){%>
    <button onclick="openPage('gdTheoDoiVay.jsp?page=<%=maxPage%>')">Trang cuối</button>
    <%}%>
</div>
</body>
</html>

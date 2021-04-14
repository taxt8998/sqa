<%@ page import="dao.ReportDAO" %>
<%@ page import="utils.FormatDate" %>
<%@ page import="utils.FormatDecimal" %>
<%@ page import="model.*" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/24/2021
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee emp = (Employee) session.getAttribute("user");
    if(emp == null) response.sendRedirect("../index.jsp");
    FormatDate formatDate = new FormatDate();
    FormatDecimal formatDecimal = new FormatDecimal();
%>
<%
    String type = request.getParameter("type");
    String period = request.getParameter("period");
    System.out.println(type);
    System.out.println(period);
    ReportLoan reportLoan = new ReportLoan();
    ReportDeposit reportDeposit = new ReportDeposit();
    ReportDAO reportDAO = new ReportDAO();

    String thisURL = String.valueOf(request.getRequestURL());
    int total = 0;
    int quantity = 10;
    int maxPage = 0;
    int pageNum ;
    try {
        pageNum = Integer.parseInt(request.getParameter("page"));
    } catch (Exception e){
        pageNum = 1;
    }
    if (type.equalsIgnoreCase("loan")){
        if (period.equalsIgnoreCase("month")){
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            total = reportDAO.getMonthQuantity(month,year);
            maxPage =(int) Math.ceil((double) total/quantity);
            if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
            reportLoan.setListLoan(reportDAO.getMonthReportLoan(month,year,pageNum));
            reportLoan.setQuantity(total);
            reportLoan.setAmount(reportDAO.getMonthTotal(month,year));
        }
        else if (period.equalsIgnoreCase("quarter")){
            int quarter = Integer.parseInt(request.getParameter("quarter"));
            int year = Integer.parseInt(request.getParameter("year"));
            total = reportDAO.getQuarterQuantity(quarter,year);
            maxPage =(int) Math.ceil((double) total/quantity);
            if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
            reportLoan.setListLoan(reportDAO.getQuarterReportLoan(quarter,year,pageNum));
            reportLoan.setQuantity(total);
            reportLoan.setAmount(reportDAO.getQuarterTotal(quarter,year));
        }
        else {
            int year = Integer.parseInt(request.getParameter("year"));
            total = reportDAO.getYearQuantity(year);
            maxPage =(int) Math.ceil((double) total/quantity);
            if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
            reportLoan.setListLoan(reportDAO.getYearReportLoan(year,pageNum));
            reportLoan.setQuantity(total);
            reportLoan.setAmount(reportDAO.getYearTotal(year));
        }
    }
    else {
        if (period.equalsIgnoreCase("month")){
            System.out.println("RESST");
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            total = reportDAO.getMonthQuantityDeposit(month,year);
            maxPage =(int) Math.ceil((double) total/quantity);
            if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
            reportDeposit.setListDeposit(reportDAO.getMonthReportDeposit(month,year,pageNum));
            reportDeposit.setQuantity(total);
            reportDeposit.setAmount(reportDAO.getMonthTotalDeposit(month,year));
        }
        else if (period.equalsIgnoreCase("quarter")){
            int quarter = Integer.parseInt(request.getParameter("quarter"));
            int year = Integer.parseInt(request.getParameter("year"));
            total = reportDAO.getQuarterQuantityDeposit(quarter,year);
            maxPage =(int) Math.ceil((double) total/quantity);
            if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
            reportDeposit.setListDeposit(reportDAO.getQuarterReportDeposit(quarter,year,pageNum));
            reportDeposit.setQuantity(total);
            reportDeposit.setAmount(reportDAO.getQuarterTotalDeposit(quarter,year));
        }
        else {
            int year = Integer.parseInt(request.getParameter("year"));
            total = reportDAO.getYearQuantityDeposit(year);
            maxPage =(int) Math.ceil((double) total/quantity);
            if (pageNum < 1 || pageNum > maxPage) pageNum = 1;
            reportDeposit.setListDeposit(reportDAO.getYearReportDeposit(year,pageNum));
            reportDeposit.setQuantity(total);
            reportDeposit.setAmount(reportDAO.getYearTotalDeposit(year));
        }
    }

%>

<html>
<head>
    <title>Xuất báo cáo</title>
</head>
<body>
    <table>

        <%if (type.equalsIgnoreCase("loan")){%>
        <tr>
            <td><label>Tổng tiền</label></td>
            <td><%=formatDecimal.formatCurrency(reportLoan.getAmount())%></td>
        </tr>
        <tr>
            <td><label>Số khoản vay</label></td>
            <td><%=reportLoan.getQuantity()%></td>
        </tr>
        <%}
        else{
        %>
        <tr>
            <td><label>Tổng tiền</label></td>
            <td><%=formatDecimal.formatCurrency(reportDeposit.getAmount())%></td>
        </tr>
        <tr>
            <td><label>Số khoản vay</label></td>
            <td><%=reportDeposit.getQuantity()%></td>
        </tr>
        <%}%>
    </table>
    <table>
        <thead>
        <td>STT</td>
        <td>Chủ tài khoản</td>
        <td>Số tài khoản</td>
        <td>Số tiền</td>
        <td>Ngày thực hiện</td>
        <td></td>
        </thead>
        <%if (type.equalsIgnoreCase("loan")){%>
        <tbody>
        <%for (int i =0 ;i<reportLoan.getListLoan().size();i++){
            Loan loan = reportLoan.getListLoan().get(i);
        %>
        <tr>
            <td><%=(pageNum -1) * quantity + i+1%></td>
            <td><%=loan.getAccount().getCustomer().getName()%></td>
            <td><%=loan.getAccount().getId()%></td>
            <td><%=formatDecimal.formatCurrency(loan.getAmount())%></td>
            <td><%=formatDate.format(loan.getStartDate())%></td>
            <td><a href="gdChiTietVay.jsp?id=<%=loan.getId()%>">Xem thêm</a></td>
        </tr>
        <%}%>
        </tbody>
        <%}
            else {
        %>
        <tbody>
        <%for (int i =0 ;i<reportDeposit.getListDeposit().size();i++){
            Deposit deposit = reportDeposit.getListDeposit().get(i);
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
        <%}%>
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

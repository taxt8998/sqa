<%@ page import="model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/24/2021
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Employee emp = (Employee) session.getAttribute("user");
    if(emp == null) response.sendRedirect("../index.jsp");
%>
<html>
<head>
    <title>Chọn loại báo cáo</title>
</head>
<body>
    <form action="gdXuatBaoCao.jsp" method="post" name="report" id="report">
        <table>
            <tr>
                <td><label>Loại báo cáo</label></td>
                <td><select name="type" >
                    <option value="loan" selected>Khoản Vay</option>
                    <option value="deposit">Khoản Tiết kiệm</option>
                </select></td>
            </tr>
            <tr>
                <td><label>Thống kê theo</label></td>
                <td><select name="period" id="period" onchange="valid(this.value)">
                    <option value="month" selected>Tháng</option>
                    <option value="quarter">Quý</option>
                    <option value="year">Năm</option>
                </select></td>
            </tr>
            <tr>
                <td><label>Tháng</label></td>
                <td><select name="month" id="month">
                    <%for (int i = 1; i<= 12; i++){%>
                    <option value="<%=i%>"><%=i%></option>
                    <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label>Quý</label></td>
                <td><select name="quarter" disabled id="quarter">
                    <%for (int i = 1; i<= 4; i++){%>
                    <option value="<%=i%>"><%=i%></option>
                    <%}%>
                </select></td>
            </tr>
            <tr>
                <td><label>Năm</label></td>
                <td><select name="year" id="year">
                    <%for (int i = 1990; i<= 2021; i++){%>
                    <option <%if (i == 2021) {%> selected <%}%> value="<%=i%>"><%=i%></option>
                    <%}%>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Xuất báo cáo</button></td>
            </tr>
        </table>
    </form>
</body>

<script type="text/javascript">
    function valid(period){
        console.log("CHANGING")
        if (period == "quarter"){
            document.getElementById("month").setAttribute("disabled","false")
            document.getElementById("quarter").removeAttribute("disabled")
        }
        else if (period == "year"){
            document.getElementById("month").setAttribute("disabled","true")
            document.getElementById("quarter").setAttribute("disabled","true")
        }
        else {
            document.getElementById("month").removeAttribute("disabled")
            document.getElementById("quarter").setAttribute("disabled","true")
        }
    }
</script>
</html>

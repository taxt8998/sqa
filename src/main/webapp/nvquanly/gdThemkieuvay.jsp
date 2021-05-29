<%-- 
    Document   : gdThemkieuvay
    Created on : Mar 22, 2021, 9:25:22 PM
    Author     : ASUS
--%>
<%@page import="java.util.*,dao.*,model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thêm kiểu vay</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("home.jsp");
            }
        %>
        <h4>Thêm kiểu vay mới </h4>
        <form action="doThemVay.jsp" method="post" name="add" id="add">
            <label for="">Tên kiểu vay mới: </label>
            <input type="text" autofocus="autofocus" id="l_name" name="l_name" placeholder="nhập tên vào đây!" required />
            <h4>Thông tin cho kiểu vay</h4>
            <ol>
                <li>
                    <h4>Áp dụng với tài khoản vàng</h4>
                    <label for="">Lãi suất: </label>
                    <input type="number"  step="0.01" min="0.0" max="20.0" id="rate_gold" name="rate_gold" placeholder="Nhập lãi theo %" required />
                    <label for="">Thời hạn tối đa: </label>
                    <input type="number" min="0" id="duration_gold" name="duration_gold" placeholder="Nhập số tháng!" required />
                </li>
                <li>
                    <h4>Áp dụng với tài khoản bạc</h4>
                    <label for="">Lãi suất: </label>
                    <input type="number" step="0.01" min="0.0" max="20.0" id="rate_silver" name="rate_silver" placeholder="Nhập lãi theo %" required />
                    <label for="">Thời hạn tối đa: </label>
                    <input type="number" min="0" id="duration_silver" name="duration_silver" placeholder="Nhập số tháng!" required />
                </li>
                <li>
                    <h4>Áp dụng với tài khoản đồng</h4>
                    <label for="">Lãi suất: </label>
                    <input type="number" step="0.01" min="0.0" max="20.0" id="rate_bronze" name="rate_bronze" placeholder="Nhập lãi theo %" required />
                    <label for="">Thời hạn tối đa: </label>
                    <input type="number" min="0" id="duration_bronze" name="duration_bronze" placeholder="Nhập số tháng!" required />
                </li>

            </ol>
            <input type="submit" value="Lưu" onclick="return confirm('Bạn có chắc muốn lưu?')" />
        </form>

    </body>
</html>

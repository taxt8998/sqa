<%-- 
    Document   : gdCauhinhVay
    Created on : Mar 19, 2021, 10:15:42 PM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file ="../header.jsp" %>
        <title>Cấu hình vay</title>
    </head>
    <body>
        <div>
            <button  onclick="openPage('gdThemkieuvay.jsp')">Thêm kiểu vay</button>
            <button  onclick="openPage('gdSualaivay.jsp')">Sửa lãi vay</button>
            <button  onclick="openPage('gdXoakieuvay.jsp')">Xóa kiểu vay</button>
        </div>
    </body>
</html>

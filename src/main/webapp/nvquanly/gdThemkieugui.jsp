<%-- 
    Document   : gdThemkieugui
    Created on : Mar 23, 2021, 9:43:56 AM
    Author     : ASUS
--%>

<%@page import="java.util.*,dao.*,model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thêm kiểu gửi</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("home.jsp");
            }
            String kieuvay = request.getParameter("limitornot");
            if (kieuvay.equalsIgnoreCase("limit")) {
                String[] checked_values = request.getParameterValues("month");
                ArrayList<Integer> duration_list = new ArrayList<Integer>();
                for (int i = 0; i < checked_values.length; i++) {
                    if (checked_values[i] != null) {
                        duration_list.add(Integer.parseInt(checked_values[i]));
                    }
                }
        %>
        <h4>Thêm kiểu gửi mới </h4>
        <form action="doThemGui.jsp" method="post" name="addgui" id="addgui">
            <h4>Thông tin cho kiểu gửi</h4>
            <label for="">Tên kiểu gửi mới: </label>
            <input type="text" autofocus="autofocus" id="d_name" name="d_name" placeholder="nhập tên vào đây!" required />
            <ol>

                <%
                    for (int i = 0; i < duration_list.size(); i++) {
                %>
                <li> 
                    <p>Kỳ hạn <%=duration_list.get(i)%> tháng</p>
                    <label for="">Lãi suất:  </label>
                    <input type="number"  step="0.01" min="0.0"  id="rate_g" name="rate_g" placeholder="Nhập lãi theo %" required />
                    <label for="">Mô tả:   </label>
                    <input type="text" id="des_name" name="des_name" placeholder="nhập mô tả vào đây!" required />
                </li>
                <%

                    }
                    session.setAttribute("duration_list", duration_list);
                %>      
            </ol>
            <input type="submit" value="Lưu" onclick="return confirm('Bạn có chắc muốn lưu?')" />
        </form>
        <%
        } else {
        %>
        <h4>Thêm kiểu gửi mới </h4>
        <form action="doThemGui.jsp" method="post" name="addgui" id="addgui">
            <label for="">Tên kiểu gửi mới: </label>
            <input type="text" autofocus="autofocus" id="d_name" name="d_name" placeholder="nhập tên vào đây!" required />
            <label for="">Lãi suất:  </label>
            <input type="number"  step="0.01" min="0.0"  id="rate_nl" name="rate_nl" placeholder="Nhập lãi theo %" required />
            <label for="">Mô tả:   </label>
            <input type="text" id="des_namenl" name="des_namenl" placeholder="nhập mô tả vào đây!" required />
            <input type="submit" value="Lưu" onclick="return confirm('Bạn có chắc muốn lưu?')" />
        </form>    
        <%
            }
        %>
    </body>
</html>

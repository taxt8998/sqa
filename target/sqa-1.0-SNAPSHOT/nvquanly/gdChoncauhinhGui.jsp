<%-- 
    Document   : gdChoncauhinhGui
    Created on : Mar 23, 2021, 2:57:25 PM
    Author     : ASUS
--%>

<%@page import="java.util.*,dao.*,model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Chọn cấu hình gửi</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("home.jsp");
            }
        %>
        <h4>Cấu hình cho kiểu gửi mới</h4>
        <form action="gdThemkieugui.jsp" method="post" name="addconfig" id="addconfig">
            <input type="radio" id="notlimit" name="limitornot" value="notlimit" checked="checked" />
            <label for="">Không quy định kỳ hạn</label><br>
            <input type="radio" id="limit" name="limitornot" value="limit" />
            <label for="">Có quy định kỳ hạn</label><br><br>
            <label for="">Chọn kỳ hạn: </label><br>
            <div class="checkbox-group required">
                <input type="checkbox" id="1month" name="month" value="1" class="group1" />
                <label for="">1 tháng </label>
                <input type="checkbox" id="3month" name="month" value="3" class="group1" />
                <label for="">3 tháng </label>
                <input type="checkbox" id="6month" name="month" value="6" class="group1" />
                <label for="">6 tháng </label>
                <input type="checkbox" id="9month" name="month" value="9" class="group1" />
                <label for="">9 tháng </label>
                <input type="checkbox" id="12month" name="month" value="12" class="group1" />
                <label for="">12 tháng </label>
                <input type="checkbox" id="18month" name="month" value="18" class="group1" />
                <label for="">18 tháng </label>
                <input type="checkbox" id="24month" name="month" value="24" class="group1" />
                <label for="">24 tháng </label>
                <input type="checkbox" id="36month" name="month" value="36" class="group1" />
                <label for="">36 tháng </label><br><br>
            </div>
            <input type="submit" id="checkBtn" value="Tiếp tục" onclick="return confirm('Bạn có chắc muốn tiếp tục?')" />
        </form>


        <script>
            $(function () {
                enable_cb();
                $("#limit").click(enable_cb);
            });
            $(function () {
                unenable_cb();
                $("#notlimit").click(unenable_cb);
            });

            function enable_cb() {
                if (this.checked) {
                    $("input.group1").removeAttr("disabled");
                } else if (this) {
                    $("input.group1").attr("disabled", true);
                }
            }
            function unenable_cb() {
                if (this.checked) {
                    $("input.group1").attr("disabled", true);
                }
            }
            $(document).ready(function () {
                $('input:checkbox').prop('checked', false);
            });
            $(document).ready(function () {
                $('input:radio').prop('checked', false);
            });
            $(document).ready(function () {
                $('#checkBtn').click(function () {
                    checked = $("input[type=checkbox]:checked").length;

                    if (!checked && document.getElementById('limit').checked) {
                        alert("Bạn phải chọn ít nhất một thời hạn");
                        return false;
                    }

                });
            });
        </script>
    </body>
</html>

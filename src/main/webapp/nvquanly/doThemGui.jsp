<%-- 
    Document   : doThemGui
    Created on : Mar 23, 2021, 9:36:53 PM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đang thêm mới</title>
    </head>
    <body>
        <%
            String raw_depname = request.getParameter("d_name");
            raw_depname = raw_depname.toLowerCase().trim().replaceAll("\\s+", " ");
            String dep_name = raw_depname.substring(0, 1).toUpperCase() + raw_depname.substring(1);
            
            String[] ratelimited_list = request.getParameterValues("rate_g");
            String rate_unlimited = request.getParameter("rate_nl");
            ArrayList<DepositType> list_dep = new ArrayList<>();
            if (rate_unlimited == null) {
                ArrayList<Integer> duration_list = (ArrayList<Integer>) session.getAttribute("duration_list");
                String[] deslimited_list = request.getParameterValues("des_name");
                
                for (int i = 0; i < ratelimited_list.length; i++) {
                    DepositType dt = new DepositType(dep_name, deslimited_list[i], Double.parseDouble(ratelimited_list[i]), duration_list.get(i));
                    list_dep.add(dt);
                }
            } else {
                
                String des = request.getParameter("des_namenl");
                DepositType dt = new DepositType(dep_name, des, Double.parseDouble(rate_unlimited));
                list_dep.add(dt);

            }    
                DepositTypeDAO dao = new DepositTypeDAO();
                if (!dao.checkExistDeposit(dep_name)) {
                    //thuc hien luu
                    boolean kq = dao.addDepType(list_dep);
                    if (kq) {
        %>
        <script type="text/javascript">
            alert("Thêm mới kiểu gửi thành công !!!");
            window.location = "gdCauhinh.jsp";
        </script>
        <%
        } else {
        %>
        <script type="text/javascript">
            alert("Lỗi thêm mới !!!");
            history.back();
        </script>
        <%
            }
        } else {
            //da ton tai
        %>
        <script type="text/javascript">
            alert("Loại gửi này đã tồn tại trong Cơ sở dữ liệu !!!");
            history.back();
        </script> 
        <%
                }
            
        %>
    </body>
</html>

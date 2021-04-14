<%-- 
    Document   : gdXoachitietgui
    Created on : Mar 24, 2021, 9:30:26 AM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
        <title>Đang xóa</title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("../index.jsp");
            }
        %>
        <%
            String kieuguixoa = request.getParameter("kieuguixoa");
            ArrayList<DepositType> listDep = (ArrayList<DepositType>) session.getAttribute("listDep");
            DepositType dt = new DepositType();
            for (int i = 0; i < listDep.size(); i++) {
                if (listDep.get(i).getName().equalsIgnoreCase(kieuguixoa)) {
                    dt.setId(listDep.get(i).getId());
                    dt.setName(listDep.get(i).getName());
                    dt.setRate(listDep.get(i).getRate());
                    dt.setDuration(listDep.get(i).getDuration());
                    dt.setDescription(listDep.get(i).getDescription());
                }
            }
            boolean kq = (new DepositTypeDAO()).deleteDep(dt);
            if (kq) {
        %>
        <script type="text/javascript">
            alert("Xóa thành công");
            window.location = "gdCauhinh.jsp";
        </script>
        <%
        } else {
        %>
        <script type="text/javascript">
            alert("Lỗi xóa!");
            history.back();
        </script>
        <%
            }
        %>
    </body>
</html>

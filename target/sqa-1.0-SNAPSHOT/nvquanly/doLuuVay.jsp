<%-- 
    Document   : doLuuVay
    Created on : Mar 22, 2021, 3:18:39 PM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đang Lưu</title>
    </head>
    <body>
        <%
            String[] laimoi = request.getParameterValues("changeLoan");
            ArrayList<LoanType> choseLoan = (ArrayList<LoanType>) session.getAttribute("choseLoan");
            ArrayList<LoanType> finalEdit = null;
            for (int i = 0; i < choseLoan.size(); i++) {
                if (choseLoan.get(i).getRate() != Double.parseDouble(laimoi[i])) {
                    if (finalEdit == null) {
                        finalEdit = new ArrayList<>();
                    }
                    choseLoan.get(i).setRate(Double.parseDouble(laimoi[i]));
                    finalEdit.add(choseLoan.get(i));
                }
            }
            if (finalEdit == null) {
        %>
        <script type="text/javascript">
            alert("Lãi đã vừa cập nhật giá trị này!");
            history.back();
        </script>
        <%
        } else {
            boolean update_result = (new LoanTypeDAO()).saveLoanRate(finalEdit);
            if (update_result) {
        %>
        <script type="text/javascript">
            alert("Cập nhật lãi thành công");
            window.location = "gdCauhinh.jsp";
        </script>
        <%
        } else { %>
        <script type="text/javascript">
            alert("Lỗi cập nhật!");
            history.back();
        </script>
        <%
                }
            }
        %>

    </body>
</html>

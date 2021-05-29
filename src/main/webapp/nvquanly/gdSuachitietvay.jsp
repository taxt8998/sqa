<%-- 
    Document   : gdSuachitietvay
    Created on : Mar 22, 2021, 3:15:32 PM
    Author     : ASUS
--%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <%
            String kieuvay = request.getParameter("kieuvay");
            ArrayList<LoanType> listLoan = (ArrayList<LoanType>) session.getAttribute("listLoan");
        %>
        <title>Sửa <%=kieuvay%></title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if(emp == null) response.sendRedirect("../index.jsp");
        %>
        <%
            ArrayList<LoanType> choseLoan = new ArrayList<>();
            for (int i = 0; i < listLoan.size(); i++) {
                if (listLoan.get(i).getName().equalsIgnoreCase(kieuvay)) {
                    choseLoan.add(listLoan.get(i));
                }
            }
            session.setAttribute("choseLoan", choseLoan);
        %>
        <div>
            <form action="doLuuVay.jsp">
                <%
                    for (int i = 0; i < choseLoan.size(); i++) {
                %>
                <h4><%=choseLoan.get(i).getDescription()%></h4>
                <h4><input type="number"  step="0.01" min="0.0" max="20" autofocus="autofocus" name="changeLoan" onkeypress="validate(event)" value="<%=choseLoan.get(i).getRate()%>" required />% </h4>
                    <%
                        }

                    %>
                <br><br>
                <input type="submit" value="Cập nhật" onclick="return confirm('Bạn có chắc muốn cập nhật?')" />
            </form>
        </div>
        <script type="text/javascript">
            $('form')
                    .each(function () {
                        $(this).data('serialized', $(this).serialize())
                    })
                    .on('change input', function () {
                        $(this)
                                .find('input:submit, button:submit')
                                .prop('disabled', $(this).serialize() == $(this).data('serialized'));
                    })
                    .find('input:submit, button:submit')
                    .prop('disabled', true)
                    ;
        </script>

        <script type="text/javascript">
            function validate(event) {
                if (event.key == "-") {
                    event.preventDefault();
                    return false;
                }
            }
        </script>

    </body>
</html>

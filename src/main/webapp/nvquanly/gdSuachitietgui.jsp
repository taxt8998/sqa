<%-- 
    Document   : gdSuachitietgui
    Created on : Mar 22, 2021, 3:32:10 PM
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
            String kieugui = request.getParameter("kieugui");
            ArrayList<DepositType> listDep = (ArrayList<DepositType>) session.getAttribute("listDep");
        %>
        <title>Sửa <%=kieugui%></title>
    </head>
    <body>
        <%
            Employee emp = (Employee) session.getAttribute("user");
            if (emp == null) {
                response.sendRedirect("home.jsp");
            }
        %>
        <%
            ArrayList<DepositType> choseDep = new ArrayList<>();
            for (int i = 0; i < listDep.size(); i++) {
                if (listDep.get(i).getName().equalsIgnoreCase(kieugui)) {
                    choseDep.add(listDep.get(i));
                }
            }
            session.setAttribute("choseDep", choseDep);
        %>
        <div>
            <form action="doLuuGui.jsp">
                <%
                    for (int i = 0; i < choseDep.size(); i++) {
                        if(choseDep.get(i).getDuration()==0){
                %>
                <h4>Kỳ hạn: vô thời hạn </h4>
                <%
                        }else{
                %>
                <h4>Kỳ hạn: <%=choseDep.get(i).getDuration()%> Tháng</h4>
                <%
                    }
                %>
                <h4><input type="number"  step="0.01" min="0.0" autofocus="autofocus" name="changeDep" onkeypress="validate(event)" value="<%=choseDep.get(i).getRate()%>" required />% </h4>

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

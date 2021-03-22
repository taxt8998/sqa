<%-- 
    Document   : doLuuGui
    Created on : Mar 22, 2021, 3:32:42 PM
    Author     : ASUS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,dao.*,model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đang lưu</title>
</head>
<body>
	<%
		String[] laimoi = request.getParameterValues("changeDep");
		ArrayList<DepositType> choseDep  = (ArrayList<DepositType>) session.getAttribute("choseDep");
		ArrayList<DepositType> finalEdit = null;
		for(int i=0;i<choseDep.size();i++){
			if(choseDep.get(i).getRate() != Double.parseDouble(laimoi[i])){
				if(finalEdit == null) finalEdit = new ArrayList<>();
				choseDep.get(i).setRate(Double.parseDouble(laimoi[i]));
				finalEdit.add(choseDep.get(i));
			}
		}
		boolean update_result = (new DepositTypeDAO()).saveDepRate(finalEdit);
		if(update_result){
	%>
			<script type="text/javascript">
				alert("Cập nhật lãi thành công");
        		window.location= "gdCauhinh.jsp";
			</script>
	<%	
		}else{ %>
			<script type="text/javascript">
        		alert("Lỗi cập nhật!");
        		history.back();
   	 		</script>
	<%	
		}
	%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>INDEX</title>
	</head>
	<body>
		<%
			bean.FileListingBean bean = new bean.FileListingBean();
			request.getSession().setAttribute("bean", bean);
			for(java.io.File file: bean.files()){
				request.getSession().setAttribute("file", file);
				%><a href='${bean.web(pageContext.request, file)}' target='_blank'><%=bean.relative(file)%></a><br><%
			}
		%>
	</body>
</html>
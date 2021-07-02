<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="${appRoot }/upload/sub01" method="post" enctype="multipart/form-data"> <!-- 파일 업로드 문법enctype 걍 외워야함 -->
											<!-- 파일업로드의 경우는 반드시 post 방식  -->
		fname : <input name="fname" value="trump" /> <br>
		file : <input type="file" name="ufile"  accept="image/*" /> <br>
		<input type="submit">
	</form>	
	
	<hr>
	
	<form action="${appRoot }/upload/sub02" method="post" enctype="multipart/form-data">
		name: <input name="name" value="donald" /> <br>
		file: <input type="file" name="file" accept="image/*" /> <br>
		<input type="submit">
	</form>
</div>
</body>
</html>
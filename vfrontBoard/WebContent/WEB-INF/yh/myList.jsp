<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>			
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Insert Title</Title>
</head>
<body>

		
<table border="1">
<tr><th>허접한 게시판 리스트 제목</th></tr>
<c:forEach var="dto" items="${myList}">
<tr>
	<th><c:out value="${dto.title }"></c:out> </th>
</tr>
</c:forEach>
</table>
		
</body>
</html>


		
</body>
</html>

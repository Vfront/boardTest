<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div align="center" id="di">
<h2>게시판</h2>
	<table border="1">
		<tr>
			<th>글번호</th><th>글쓴이</th><th>제목</th><th>날짜</th>
		</tr>
		<c:forEach var="each" items="${ boardList }">
			<tr>
				<td>${each.num }</td>
				<td id="${each.num}" class="writer">${each.writer }</td>
				<td>${each.title }</td>
				<td>${each.regdate }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript">
	$(".writer").click(function(){
		alert("aler");
		var id = $(this).attr("id");
		alert(id);
	});
	$("#di").click(function(){
		alert("11");
	});
 </script>
</body>
</html>
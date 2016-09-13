<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/vfrontBoard/WEB-INF/js_files/jquery-1.7.2.min.js"></script>
</head>
<body>


<div align="center" id="di">
<h2>게시판</h2>
	<table border="1">
		<tr>
			<th id="z">글번호</th><th>글쓴이</th><th>제목</th><th>날짜</th>
		</tr>
		<c:forEach var="each" varStatus="i" items="${ boardList }">
			<tr>
				<td>${each.num }</td>
				<td id="${each.num}" class="writer">${each.writer }</td>
				<td><a onclick="showCont('${i.index}')">${each.title }</a></td>
				<td>${each.regdate }</td>
			</tr>
				<tr style="display: none;"  class="showArea${ i.index }">
					<td>${ each.contents }</td>				
				</tr>
		</c:forEach>
	</table>
	<div id="aa">zz</div>
</div>
<script type="text/javascript">

	$("#z").click(function(){
		
		alert("zz");
	});
	

	function showCont(i){
		alert(i);
		var name = ".showArea"+i;
		$(name).slideDown(100);
		alert(i+"ss");
	}
 </script>
</body>
</html>
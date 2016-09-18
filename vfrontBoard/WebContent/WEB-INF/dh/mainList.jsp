<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

</head>
<body>
<c:if test="${boardList ne null }">
	<table>
			<tr>
				<td>아이디</td>
				<td>제목</td>
				<td>작성날짜</td>
				<td>&nbsp; &nbsp;</td>
			
			</tr>
		<c:forEach var="each" items="${boardList }">
			<tr>
				<td>${each.user_id }</td>
				<td>${each.title }</td>
				<td>${each.board_date }</td>
				<td>
						<input type="button" value="상세보기"  
						id="${each.board_id }" class="detailB"/>
				</td>			
			</tr>
		</c:forEach>
	</table>
</c:if>


<script type="text/javascript">
$(".detailB").click(function(){
	alert("clicked!");
});
</script>

</body>
</html>
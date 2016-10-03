<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Insert Title</Title>
<!-- <script type="text/javascript" src="/vfrontBoard/WebContent/WEB-INF/yh/jquery-1.7.2.min.js"></script> -->

<script type="text/javascript">
// $(document).ready(function(){
// 	$("#abc").click(function(){
		
// 		alert("aa");
// 		var mydata = $("#puttingdata").serialize();
// 		alert("abc");
// 		$.ajax({
// 			type:"POST",
// 			url:"/vfrontBoard/board.do/yh/insert",
// 			data : mydata,
// 			dataType:"text",
// 			success:function(response){
// 				if(response=='1'){
// 					alert("성공!");
// 				}else{
// 					alert("실패");
// 				}
// 			}			
// 		});
		
	

// 	});
	
	
// });

function insert(){
	var frm = document.getElementById("puttingdata");
	frm.action = "/vfrontBoard/board.do/yh/insert";
	frm.method="post";
	frm.submit();
}

</script>


</head>
<body>



<h2 id='numcheck'>
<c:choose>
<c:when test="${num!=null}">
${num}
</c:when>
<c:otherwise>
0
</c:otherwise>
</c:choose>개의 게시물이 있네요.</h2>
collaborator 테스트
<a href="/vfrontBoard/board.do/yh/showList">게시물 리스트 보기</a>
<hr>

<form id="puttingdata">
<table>
<tr>
<td>제목</td>
<td><input type="text" name="title"/></td>
</tr>
<tr>
<td></td>
<td><textarea name="content"></textarea></td>
</tr>
</table>
</form>
<button id="abc" onclick="javascript:insert()">테스트</button>

</body>
</html>

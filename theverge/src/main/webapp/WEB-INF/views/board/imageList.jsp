<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<table>
		<c:forEach items="${list }" var="item" varStatus="status">
		<c:set var="index" value="${status.index }"/>
			<c:if test="${status.index % 5 eq 0}">
				<tr>
			</c:if>
			<td style="padding:10px;cursor:pointer;"><img class="img" src="/resources/${item.filename }" style="width:200px;height:200px;">
			<a href="#" class="delete" data-num="${item.num }">DELETE</a>
			</td>
			<c:if test="${status.index % 5 eq 4}">
					</tr>
			</c:if>

		</c:forEach>
		<c:if test="${index % 5 ne 4 }">
		</tr>
		</c:if>
	</table>
<script>
$(".img").on("click",function(){
	var width=$(this).prop("naturalWidth");
	var height=$(this).prop("naturalHeight");
	var src=$(this).attr("src");
	window.open(src,"asdfsdf","width="+width+",height="+height);
});
$(".delete").click(function(){
	var num=$(this).data("num");
	$.ajax({
		method:"DELETE",
		headers:{
			"Content-Type":"application/json",
			"X-HTTP-METHOD-Override":"DELETE"
		},
		dataType:"text",
		url:"/imageBoard/"+num,
		success:function(result){
			location.reload();
		},
		error:function(a,b,c){
			alert(a);
		},
		
	});
});
</script>
</body>
</html>

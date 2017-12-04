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
	<form method="get" action="board">
		<select class="form-control" name="searchType">
			<option value="title">Title</option>
			<option value="content">Content</option>
			<option value="writer">Writer</option>
			<option value="all">All</option>
		</select>
		<div class="input-group">

			<input type="text" name="keyword" class="form-control"> <input
				type="hidden" name="category" value="${param.category}" />
			<div class="input-group-btn">
				<input type="submit" class="btn btn-default" value="search" />
			</div>
		</div>
	</form>
	<div class="container">
		<div class="row">
			<a href="/board/write2?category=${param.category }">Write</a>
		</div>
	</div>
	<table>
		<tr>
			<td>No</td>
			<td>Writer</td>
			<td>Title</td>
			<td>Count</td>

			<td>Date</td>
		</tr>
		<c:forEach items="${list }" var="item">
			<tr>
				<td>${item.rownum }</td>
				<td
					<c:if test="${item.lvl ne 0 }">style='padding-left:${item.lvl*10 }px'</c:if>>${item.writer }</td>
				<td><a
					href="/board/read${pageMaker.makeSearch(pageMaker.cri.page)}&category=${item.category }&num=${item.num }&lvl=${item.lvl}&groupNum=${item.groupNum}&sequence=${item.sequence}">${item.title }</a></td>
				<td>${item.cnt }</td>

				<td>${item.writtendate }</td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination">
		<c:if test="${pageMaker.prev }">
			<li><a href="#">&laquo;</a>
		</c:if>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="index">
			<li ${index eq param.page ?"class='active'":""}><a
				href="board?category=${param.category }&page=${index }">${index }</a>
		</c:forEach>
		<c:if test="${pageMaker.next }">
			<li><a href="#">&raquo;</a>
		</c:if>
	</ul>
</body>
</html>

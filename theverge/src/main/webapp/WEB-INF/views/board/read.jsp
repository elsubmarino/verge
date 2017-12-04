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
	<div class="container-fluid">
		<div class="row"><a href="download?filename=${dto.filename}">${dto.filename }</a></div>
		<div class="row">${dto.content}</div>
		<div class="row">

			<a
				href="/board/write?groupNum=${param.groupNum }&lvl=${param.lvl}&sequence=${param.sequence}&category=${param.category}"
				class="btn btn-default">Reply</a>
			<form action="/board/delete" method="post">
				<input type="hidden" name="groupNum" value="${param.groupNum }">
				<input type="hidden" name="lvl" value="${param.lvl }"> <input
					type="hidden" name="sequence" value="${param.sequence }"> <input
					type="hidden" name="category" value="${param.category }"> <input
					type="hidden" name="num" value="${param.num }" />
					<input
					type="hidden" name="page" value="${cri.page }" />
					<input type="hidden" name="searchType" value="${cri.searchType }"/>
					<input type="hidden" name="keyword" value="${cri.keyword }"/>
					 <input
					type="submit" class="btn btn-default" value="DELETE">
			</form>
		</div>
		<div class="row">
			<form action="/article/write" method="post">
				<input type="text" name="writer"> <input type="hidden"
					name="category" value="${param.category }" /> <input type="hidden"
					name="parentNum" value="${param.groupNum }" /> <input
					type="hidden" name="sequence" value="0" /> <input type="hidden"
					name="num" value="${param.num }" /> <input type="hidden"
					name="lvl" value="${param.lvl }" /> <input type="hidden"
					name="groupNum" value="${param.groupNum }" />
				<textarea name="content"></textarea>
				<input type="submit" value="submit" />
			</form>
		</div>
		<div class="container">
			<div class="row">
				<c:forEach items="${list }" var="item">
					<div
						<c:if test="${item.lvl ne 0 }">style='padding-left:${item.lvl*10 }px'</c:if>>
						<div class="row">${item.writer }</div>
						<div class="row">
							<a href="#comments_modal" data-toggle="modal"
								data-lvl="${item.lvl }" data-sequence="${item.sequence }"
								data-groupNum=${item.groupNum }>${item.content }</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="modal fade" id="comments_modal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<form action="/article/write" method="post">
							<input type="hidden" name="parentNum" value="${param.groupNum }">
							<input type="text" name="writer"> <input type="hidden"
								name="category" value="${param.category }" /> <input
								type="hidden" name="sequence" id="sequence" /> <input
								type="hidden" name="lvl" id="lvl" /> <input type="hidden"
								name="num" value="${param.num }" /> <input type="hidden"
								name="groupNum" id="groupNum" />
							<textarea name="content"></textarea>
							<input type="submit" value="submit" />
						</form>
					</div>
					<div class="modal-footer">
						<a class="btn btn-default" data-dismiss="modal">close</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$("[data-toggle='modal']").click(function() {
				var lvl = Number($(this).data("lvl")) + 1;
				$("#sequence").val($(this).data("sequence"));
				$("#lvl").val(lvl);
				$("#groupNum").val($(this).data("groupnum"));
			});
		});
	</script>
</body>
</html>

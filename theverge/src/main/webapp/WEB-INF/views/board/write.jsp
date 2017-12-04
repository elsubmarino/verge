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
		<form method="post" action="/board/write">
			 <input type="hidden" name="groupNum"
				value="${param.groupNum }" /> <input type="hidden" name="lvl"
				value="${param.lvl }" /> <input type="hidden" name="sequence"
				value="${param.sequence }" /> <input type="hidden" name="category"
				value="${param.category }" /> <input type="text" name="writer">
			<input type="text" name="title">
			<textarea name="content"></textarea>
			<input type="submit" value="submit">
		</form>
	</div>
</body>
</html>

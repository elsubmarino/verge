<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
asdfsdfsfd
	${ex.getMessage() }
	<c:forEach items="${ex.getStackTrace() }" var="item">
	${item}<br />

	</c:forEach>
</body>
</html>
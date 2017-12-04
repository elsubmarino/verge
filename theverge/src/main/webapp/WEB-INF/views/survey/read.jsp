<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<form method="post" action="/survey/vote">
		<c:forEach items="${list }" var="item">
			<div class="row">
				<input type="radio" name="num" value="${item.num }">
				${item.title }
				<fmt:formatNumber type="percent" value="${item.count / max}"></fmt:formatNumber>
			</div>
		</c:forEach>
		<input type="submit" value="Vote" />
	</form>
</div>

</body>
</html>

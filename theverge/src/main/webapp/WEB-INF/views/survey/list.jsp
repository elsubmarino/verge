<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<a href="/survey/write">Write</a>
	<table>
		<tr>
			<td>num</td>
			<td>writer</td>
			<td>title</td>
		</tr>
		<c:forEach items="${list }" var="item">
			<tr>
				<td>${item.num }</td>
				<td>${item.writer }</td>
				<td><a href="/survey/read?num=${item.num }">${item.title }</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

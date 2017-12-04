<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<form method="post" action="/survey/write">
		<div class="row">
			<input type="text" name="title">
			<input type="text" name="writer">
			<textarea name="content"></textarea>
			<button class="btn btn-default" id="addButton">Add Item</button>
			<div id="wrapperForItems">
				<input type="text" name="item">		
			</div>
		</div>
		<div class="row">
			<input type="submit" value="submit">
		</div>
	</form>
</div>

<script>
	$(function() {
		$("#addButton").click(function(evt) {
			evt.preventDefault();
			$("#wrapperForItems").append("<input type='text' name='item'>");
		});
	});
</script>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<link rel="stylesheet" href="/resources/custom.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:white;color:black;">
	<nav class="col-md-12 navbar navbar-inverse"
		style="margin-bottom: 0; border-radius: 0;">
		<ul class="nav navbar-nav navbar-center">
			<c:forEach items="${bigCategory }" var="item" varStatus="ind">
				<c:if test="${item.subname ne null}">
					<c:if test="${check eq null}">

						<li class='dropdown'><a data-toggle='dropdown'
							href=${item.url }>${item.name } <span class='caret'></span>
						</a>
							<ul class='dropdown-menu'>
								<li><a href=${item.url }>${item.subname }</a></li>
					</c:if>
					<c:if test="${check ne null and check ne item.name}">
		</ul>
		</li>
		<li class='dropdown'><a data-toggle='dropdown' href=${item.url }>${item.name }
				<span class='caret'></span>
		</a>
			<ul class='dropdown-menu'>
				<li><a href='#'>${item.subname }</a></li>
				</c:if>
				<c:if test="${check eq item.name}">
					<li><a href='#'>${item.subname }</a></li>

				</c:if>
				</c:if>
				<c:if test="${item.subname eq null }">

					<c:if test="${check2 ne null }">
			</ul></li>
		<li><a href=${item.url }>${item.name }</a></li>
		</c:if>
		<c:if test="${check2 eq null }">

			<li><a href=${item.url }>${item.name }</a></li>
		</c:if>
		</c:if>


		<c:set var="check" value="${item.name }" />
		<c:set var="check2" value="${item.subname }" />
		</c:forEach>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a data-toggle="dropdown" href="#"><i
					class="glyphicon glyphicon-user"></i></a>
				<ul class="dropdown-menu">
					<li><a href="/login">Log In</a></li>
					<li><a href="/signup">Sign Up</a></li>
					<c:if test="${sessionScope.id ne null }">
						<li><a href="/logout">Log Out</a></li>
					</c:if>
				</ul></li>
			<li class='dropdown' style='position: initial'><a
				data-toggle='dropdown' href="#"><i
					class="glyphicon glyphicon-search"></i></a>
				<ul class='dropdown-menu' style='width: 100%'>
					<li>
						<form>
							<div class="input-group">

								<input type="text" class='form-control' placeholder="Search"
									autofocus>
								<div class="input-group-btn">
									<button class='btn btn-default'>Search</button>
								</div>
							</div>
						</form>
					</li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><i class="fa fa-facebook"></i></a></li>
			<li><a href="#"><i class="fa fa-twitter"></i></a></li>
			<li><a href="#"><i class="fa fa-rss"></i></a></li>
		</ul>

	</nav>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<link rel="stylesheet" href="/resources/custom.css" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse" style="margin-bottom: 0;">
		<div class="navbar-header">
			<div class="navbar-brand">THE VERGE</div>
		</div>
		<ul class="nav navbar-nav navbar-center">
			<c:forEach items="${bigCategory }" var="item" varStatus="ind">
				<c:if test="${item.subname ne null}">
					<c:if test="${check eq null}">

						<li class='dropdown'><a data-toggle='dropdown' href='#'>${item.name }
								<span class='caret'></span>
						</a>
							<ul class='dropdown-menu'>
								<li><a href='#'>${item.subname }</a></li>
					</c:if>
					<c:if test="${check ne null and check ne item.name}">
		</ul>
		</li>
		<li class='dropdown'><a data-toggle='dropdown' href='#'>${item.name }
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
		<li><a href="#">${item.name }</a></li>
		</c:if>
		<c:if test="${check2 eq null }">

			<li><a href="#">${item.name }</a></li>
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

	</nav> --%>
	<div>${dto.title }</div>
	<div>
		by <span class="text-capitalize">${dto.writer }</span>
		${dto.writtendate }
	</div>
	<div>
		<img src="${dto.imageurl }">
	</div>
	<div>${dto.content }</div>
	<div>TEHRE IS ${fn:length(comments) } COMMENT</div>
	<c:if test="${sessionScope.id ne null }">
		<form method="POST" action="/article/write?num=${param.num }">
			<div>
				<a href="#myModal" data-toggle="modal">Write</a>
			</div>
			<div class="modal fade" id="myModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"></div>
						<div class="modal-body">
							<textarea name="content" class="form-control" rows="20"></textarea>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-default"
								value="Write">
							<button class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</c:if>
	<c:forEach items="${comments }" var="item">
		<div id="${item.num }" class="panel panel-default"
			style="color: black; <c:if test="${item.depth ne 0 }">margin-left:${item.depth*25 }px;</c:if>">
			<div class="panel-body">
				<div class="row">${item.writer}</div>
				<div class="row">${item.content }</div>
				<div class="row">Posted on ${item.writtendate }</div>
				<c:if test="${sessionScope.id ne null }">
					<div class="row">
						<a href="/article/write">Write</a>
					</div>
				</c:if>
			</div>
		</div>
	</c:forEach>

</body>
</html>
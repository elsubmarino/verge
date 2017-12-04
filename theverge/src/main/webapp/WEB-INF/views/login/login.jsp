<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>

</head>
<body>
	THE VERGE
	<ul class="nav nav-tabs">
		<li class=${mode eq 'login'?"active":"" }><a href="#login"
			data-toggle="tab">LOG IN</a>
		<li class=${mode eq 'signup'?"active":"" }><a href="#signup"
			data-toggle="tab">SIGN UP</a>
	</ul>
	<div class="tab-content">
		<div class="tab-pane ${mode eq 'login'?'active':'' }" id="login">
			<form method="post" action="/login">
				<input type="text" name="id"> <input type="password"
					name="password">
				<button>LOGIN</button>
				<a href="#">Forgot your username?</a> <a href="#">Forgot your
					password?</a>
			</form>
		</div>
		<div class="tab-pane ${mode eq 'signup'?'active':'' }" id="signup">
			<form method="post" action="/signup">
				<input type="text" name="id"> <input name="password"
					type="password">
				<!-- <input
					type="email">-->


				<div class="g-recaptcha" data-sitekey="${siteKey }"></div>
				<input type="submit" value="SIGN UP" />

			</form>
		</div>
	</div>
	<script>
		
	</script>
</body>
</html>
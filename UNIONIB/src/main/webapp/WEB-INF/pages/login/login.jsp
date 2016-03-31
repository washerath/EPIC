<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
--@Author : Asitha Perera
--@Date Time : Mar 18, 2016 : 6:26:13 AM
--%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width-divice-width, initial-scale=1.0">
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<!-- Theme style -->
<link href="resources/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />

<link href="resources/css/welcome.css" rel='stylesheet' type='text/css' />
<!--         <link href="resources/css/tile/style.css" type="text/css" rel="stylesheet" > -->
<!--         <link href="resources/css/slideshow/stylesheet.css" type="text/css" rel="stylesheet" > -->

<link rel="icon" type="image/png" href="resources/images/image.png" />
<!--         <script src="resources/js/jquery-1.7.2.min.js"></script> -->
<!--         <script src="resources/js/slideshow/jquery.script.js"></script> -->
<!--         <script src="resources/js/jquery.inputmask.regex.extensions.js"></script> -->
<title>Welcome to Union Internet Banking</title>
</head>
<body style="background-color: #032C67;">
	<div class="container">

		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12 hidden-xs"
				style="text-align: center;">
				<div class="header">
					<header class="login inner w-12">
						<h3>
							<img class="header-image" src="resources/img/logo.png">
						</h3>
						<h3 id="header-1">Welcome to Union Bank Online Banking</h3>
						<h4 style="color: white;">Experience Banking at Your
							Fingertips</h4>
					</header>
				</div>
				<h5 style="color: white;">
				Language : <a href="?language=en">| English </a><a href="?language=si_LK">| සිංහල |</a><a href="?language=ta_LK"> தமிழ் |</a>

				Current Locale : ${pageContext.response.locale}</h5>
			</div>
		</div>
		<div class="row" style="padding-left: 35%; padding-right: 35%;">
			<div class="login-box-body">
				<div class="login-logo">
					<img src="resources/img/logo.png"
						class="img-responsive header-image-2" alt="" />
				</div>
				<!-- /.login-logo -->
				<p class="login-box-msg" style="text-align: center;"><spring:message code="lbl.username" /></p>
				<form:form action="checkUsername.htm" modelAttribute="loginform">
					<div class="form-group has-feedback">
						<form:input path="username" cssClass="form-control"
							required="required" placeholder="Username" />
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
					</div>
					<div class="social-auth-links text-center">
						<input type="submit"
							Class="btn btn-primary btn-block btn-flat form-control input-sm"
							style="margin: auto" value="Login" />

					</div>
					<c:if test="${message.message != null}">
						${message.message}
					</c:if>
				</form:form>
			</div>
		</div>

		<div class='lockscreen-footer text-center'
			style="padding-top: 30px; font-size: 11px; color: white;">
			<b>Version 1.0</b><br> <b>Powered by Epic Lanka Technologies
				(pvt) Ltd. &copy; 2016</b><br> All rights reserved
		</div>
	</div>
</body>
</html>
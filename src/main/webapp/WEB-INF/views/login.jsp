<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- Font -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Muli'
	rel='stylesheet'>
<!-- Stylesheet -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/assets/css/style.css">
<!-- Responsive Styleshee -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/assets/css/responsive.css">

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/date-fns/1.29.0/date_fns.min.js"></script>
<title>login</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-sm-4 login-section">
				<div class="title-card">
					<h1 class="Clear-Desk-XR">ClEAR DESK XR</h1>
					<h3 class="admin-dashboard">Admin Dashboard</h3>
				</div>
				<form:form id="loginForm" modelAttribute="login" method="POST"
					action="process_login_custom">
					<div class="form-placeholder">
						<div class="form-item">
							<div class="form-label ">
								<h3 class="login-form-label">Employee ID</h3>
							</div>
							<div class="form-control-holder">
								<form:input path="employeeId" id="employeeId"
									class="form-control  login-form-control  " value=""
									name="username" placeholder="Enter Employee ID" required="required" />
							</div>
						</div>
						<div class="form-item">
							<div class="form-label ">
								<h3 class="login-form-label">Password</h3>
							</div>
							<div class="form-control-holder">
								<form:password path="password" id="password"
									class="form-control  login-form-control " name="password"
									placeholder="**********"  required="required" />
							</div>
						</div>
						<div class="forget-password-sec-holder">
							<a class="forget-password-link" href="reset_password">
								Forgot Your Password? </a>
							<form:button id="login" name="login" class="btn  login-btn"> Login </form:button>
						</div>
					</div>
				</form:form>
				<div class="logo-holder">
					<img
						src="<%=request.getContextPath()%>/static/assets/img/login/lad-stack-rgb-white.jpg"
						class="img-responsive img logo-img" alt="">
				</div>
			</div>
			<div class="col-sm-8 login-background hideonmob"></div>
		</div>
	</div>

</body>
</html>
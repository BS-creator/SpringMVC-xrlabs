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
<title>Rest_Password</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-sm-4 login-section">
				<div class="title-card">
					<h1 class="Clear-Desk-XR">ClEAR DESK XR</h1>
					<h3 class="admin-dashboard">Admin Dashboard</h3>
				</div>
				<form method="POST" action="handle_resetpassword">
					<input type="hidden" name="_token"
						value="YBhRI9cdDXRLzVTdSujHsuYgkzj8J0CvRP9VaV0R">
					<div class="form-item">
						<div class="form-label ">
							<h3 class="login-form-label">Email Address</h3>
						</div>
						<div class="form-control-holder">
							<input id="email" type="email" class="form-control  login-form-control" name="email"
								value="" required="required" autofocus="autofocus">
						</div>

					</div>

					<div class="form-group row mt-5">
						<div class="col-md-6 offset-md-4">
							<br> <br> <br> <br>
							<button type="submit" class="btn  login-btn ">Send Password To Email</button>
						</div>
					</div>
				</form>
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
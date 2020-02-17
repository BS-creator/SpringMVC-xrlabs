<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
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
<title>admin</title>
</head>
<body>
	<section>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2 black-bg">
					<div class="title-card">
						<h1 class="sidebar_first_title">ClEAR DESK XR</h1>
						<h3 class="sidebar_second_title">Super Admin Dashboard</h3>

					</div>
					<div class="sidebar_menu">
						<ul>
							<li class="active"><a
								href="<%=request.getContextPath()%>/admin">Home </a></li>
							<li class=""><a
								href="<%=request.getContextPath()%>/add_admin">Add New Admin
							</a></li>
						</ul>
					</div>
					<div class="sidebar_footer">
						<div class="sidebar_menu">
							<ul>
								<li><a href="<%=request.getContextPath()%>/logout">Logout
										<i class="sidebar_icon "> <img
											src="<%=request.getContextPath()%>/static/assets/img/sidebar/log-out.png"
											class="img img-responsive img-thumbnail logout-logo"></i>
								</a></li>
							</ul>
						</div>
						<img
							src="<%=request.getContextPath()%>/static/assets/img/sidebar/lad-stack-rgb-white.png"
							class="img img-responsive sidebar_logo" alt="">
					</div>
				</div>

				<div class="col-sm-10">
					<div class="row">
						<div class="top_title_section">
							<div class="col-sm-6">
								<h1 class="page_title">Admins</h1>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<div class="search_bar_holder">
								<input type="search" name="search"
									class="form-control-search form-control empty"
									id="searchInputNormal" placeholder="Search ">
							</div>
						</div>
					</div>

					<div class="row"
						style="margin-top: 50px; max-height: 450px; overflow: auto;">

						<div class="col-sm-1"></div>
						<div class="col-sm-10 ">

							<div class="table-responsive " style="margin-top: 50px">
								<table class="table table-hover " id="normalTable">
									<thead>
										<tr>
											<th>#</th>
											<th>Name</th>
											<th>Username</th>
											<th>Email</th>
											<th>Actions</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${users}" varStatus="loop">
											<tr>
												<td>${loop.index + 1}</td>
												<td>${user.name}</td>
												<td>${user.eid}</td>
												<td>${user.email}</td>
												<td>
												<a href="edit_admin/${user.id}" class="btn btn-default"><span class="fa fa-edit"></span></a> 
												<a href="delete_admin/${user.id}" class="btn btn-default admin-del"><span class="fa fa-trash"></span></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/assets/js/custom.js"></script>
</body>
</html>
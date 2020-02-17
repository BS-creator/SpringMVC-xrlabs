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
<title>CLEAR DESK XR</title>
</head>
<body>
	<section>
		<div id="alert-holder"></div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2 black-bg">
					<div class="title-card">
						<h1 class="sidebar_first_title">ClEAR DESK XR</h1>
						<h3 class="sidebar_second_title">Admin Dashboard</h3>
						<div class="dropdown visibleonmob">
							<button class="btn theme-btn dropdown-toggle " type="button"
								data-toggle="dropdown">
								MENU <span class="fa fa-bars"></span>
							</button>
							<ul class="dropdown-menu main_nav_mobile_dropdown">
								<li><a href="<%=request.getContextPath()%>/sessions" class="dropdown_title">Sessions</a></li>
								<li class="divider"></li>
								<li><a href="<%=request.getContextPath()%>/trainee" class="dropdown_title">Trainees</a></li>
								<li><a href="<%=request.getContextPath()%>/login" class="dropdown_title">Logout</a></li>

							</ul>
						</div>
					</div>
					<div class="sidebar_menu">
						<ul>
							<li class=""><a href="<%=request.getContextPath()%>/sessions">Sessions </a></li>
							<li class="active"><a href="<%=request.getContextPath()%>/trainee">Trainee
									Record </a></li>
						</ul>
					</div>
					<div class="sidebar_footer">
						<div class="sidebar_menu">
							<ul>
								<li class=""><a href="<%=request.getContextPath()%>/archives">Archives</a></li>
								<li><a href="<%=request.getContextPath()%>/login">Logout <i
										class="sidebar_icon "> <img
											src="<%=request.getContextPath()%>/static/assets/img/sidebar/log-out.png"
											class="img img-responsive img-thumbnail logout-logo"></i></a></li>


							</ul>
						</div>
						<img src="<%=request.getContextPath()%>/static/assets/img/sidebar/lad-stack-rgb-white.png"
							class="img img-responsive sidebar_logo" alt="">
					</div>
				</div>
				<div class="col-sm-10">

					<div class="row">
						<div class="top_title_section">
							<div class="col-sm-6">
								<h1 class="page_title">Trainees</h1>
							</div>
							<div class="col-sm-6">
								<div class="dropdown dropright pull-right">
									<button class="btn theme-btn dropdown-toggle download_btn"
										type="button" data-toggle="dropdown">
										Add Records <span class="caret"></span>
									</button>
									<ul class="dropdown-menu add_record">

										<li><a class="dropdown_menu_item" data-toggle="modal"
											data-target="#myModal">Add Trainee Record</a></li>
										<li><a href="#" class="dropdown_menu_item"
											data-toggle="modal" data-target="#import">Bulk Add
												Trainee Records</a></li>
										<li><a href="#" class="dropdown_menu_item traineeexport">Export
												Trainee Record</a></li>
									</ul>
								</div>
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

							<div class="content-table">
								<tr class="table-responsive">
									<table class="table" id="normalTable">
										<thead>
											<tr>
												<th>NAME</th>
												<th>EMP ID</th>
												<th>ATTEMPTS</th>
												<th>BEST TIME</th>
												<th></th>
											</tr>

										</thead>
										<tbody>
											<c:forEach var="trainee" items="${trainees}" varStatus="loop">
											<tr>
												<td>
													<c:if test="${not empty trainee.pictureBase64}">
														<img src="data:image/jpeg;base64,${trainee.pictureBase64}"
																class="img img-thumbnail avatar" />
													</c:if>
													<c:if test="${empty trainee.pictureBase64}">
														<img class="img img-thumbnail avatar"  src="<%=request.getContextPath()%>/static/assets/img/profile/no-profile.jpeg" />
													</c:if>
													<h4 class="avatar_name" style="text-transform: capitalize">${trainee.employee_name}</h4></td>
												<td>
													<h5>${trainee.id}</h5>
												</td>
												<td>

													<h5>${trainee.attempt}</h5>
												</td>
												<td>
													<h5>${trainee.best_time}</h5>
												</td>
												<td><a href="detail/${trainee.id}"> <img
														src="<%=request.getContextPath()%>/static/assets/img/sidebar/arrow_head.png"
														class="img img-thumbnail img-responsive arrow_head_only"></a>
												</td>
											</tr>
											</c:forEach>

										</tbody>
									</table>
							</div>
						</div>
					</div>
					<div class="col-sm-2"></div>
				</div>


				<!-- The Modal -->
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal body -->
							<div class="modal-body">
								<div class="model_content_holder">
									<h3 class="model_title">Add Trainee</h3>
									<form:form commandName="trainee" method="post" action="trainee_add" enctype="multipart/form-data">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class="form-item">
											<div class="form-label ">
												<h3 class="login-form-label">Employee ID</h3>
											</div>
											<div class="form-control-holder">
												<form:input path="id" type="number" class="form-control  login-form-control"
													name="id" placeholder="Enter Employee ID" value="" required="required" />
											</div>
										</div>
										<div class="form-item">
											<div class="form-label ">
												<h3 class="login-form-label">Name</h3>
											</div>
											<div class="form-control-holder">
												<form:input path="employee_name" type="text" class="form-control  login-form-control"
													name="employee_name" placeholder="Enter Name" required="required" />
											</div>
										</div>
										<div class="form-item">
											<div class="form-label ">
												<h3 class="login-form-label">Email ID</h3>
											</div>
											<div class="form-control-holder">
												<form:input type="email" path="employee_email" class="form-control  login-form-control"
													name="employee_email" placeholder="Enter Email ID" required="required" />
											</div>
										</div>
										<div class="form-item">
											<div class="form-label ">
												<h3 class="login-form-label">Profile Picture</h3>
											</div>
											<div class="form-control-holder">
												<form:input type="file" path="picture" class="form-control  login-form-control"
													name="picture" accept="image/*" />
											</div>
										</div>

										<input type="submit" value="ADD"
											class="btn  theme-btn modelbtn">
									</form:form>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="modal" id="import">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal body -->
							<div class="modal-body">
								<div class="model_content_holder">
									<h3 class="model_title">Add Trainee</h3>
									<form action="UploadFileServlet" method="POST"
										enctype="multipart/form-data">
										<div class="form-item">
											<div class="form-label ">
												<h3 class="login-form-label">CSV</h3>
											</div>
											<div class="form-control-holder">
												<input type="file" class="form-control  login-form-control" name="fileName" />
											</div>
										</div>
										<button class="btn  theme-btn modelbtn">Import User
											Data</button>
									</form>
								</div>
							</div>

						</div>
					</div>
				</div>


				<div id="dvData">
					<table class="d-none">
						<tr>
							<td>Employee ID</td>
							<td>Employee Name</td>
							<td>Employee Email</td>
							<td>Attempt</td>
							<td>Best time</td>

						</tr>
						<c:forEach var="trainee" items="${trainees}" varStatus="loop">
						<tr>
							<td>${trainee.id}</td>
							<td>${trainee.employee_name}</td>
							<td>${trainee.employee_email}</td>
							<td>${trainee.attempt}</td>
							<td>${trainee.best_time}</td>
						</tr>
						</c:forEach>
					</table>
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
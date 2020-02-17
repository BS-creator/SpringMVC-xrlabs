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
								<li><a href="<%=request.getContextPath()%>/sessions"
									class="dropdown_title">Sessions</a></li>
								<li class="divider"></li>
								<li><a href="<%=request.getContextPath()%>/trainee"
									class="dropdown_title">Trainees</a></li>
								<li><a href="<%=request.getContextPath()%>/login"
									class="dropdown_title">Logout</a></li>

							</ul>
						</div>
					</div>
					<div class="sidebar_menu">
						<ul>
							<li class=""><a
								href="<%=request.getContextPath()%>/sessions">Sessions </a></li>
							<li class="active"><a
								href="<%=request.getContextPath()%>/trainee">Trainee Record
							</a></li>
						</ul>
					</div>
					<div class="sidebar_footer">
						<div class="sidebar_menu">
							<ul>
								<li class=""><a
									href="<%=request.getContextPath()%>/archives">Archives</a></li>
								<li><a href="<%=request.getContextPath()%>/logout">Logout
										<i class="sidebar_icon "> <img
											src="<%=request.getContextPath()%>/static/assets/img/sidebar/log-out.png"
											class="img img-responsive img-thumbnail logout-logo">
									</i>
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

							<a href="<%=request.getContextPath()%>/sessions"><img
								src="<%=request.getContextPath()%>/static/assets/img/dashboard/arrow-left.png"
								class="img img-thumbnail img-responsive back_btn" alt=""></a>

							<div class="col-sm-1"></div>
							<div class="col-sm-10">

								<div class="name_holder">


									<div class="col-sm-2">

										<c:if test="${not empty trainee.pictureBase64}">
											<img src="data:image/jpeg;base64,${trainee.pictureBase64}"
												class="img img-thumbnail top_avatar" />
										</c:if>
										<c:if test="${empty trainee.pictureBase64}">
											<img class="img img-thumbnail top_avatar"
												src="<%=request.getContextPath()%>/static/assets/img/profile/no-profile.jpeg" />
										</c:if>
									</div>
									<div class="col-sm-7">
										<h4 class="top_avatar_name">${trainee.employee_name}</h4>
										<div class="top_title_info_holder">
											<h3 class="top_title_info">Emp ID : ${trainee.id}</h3>
											<h3 class="top_title_info">Email:
												${trainee.employee_email}</h3>
										</div>

									</div>
									<div class="col-sm-2">
										<a href=" " class="btn theme-btn detail_download_btn export">
											<img
											src="<%=request.getContextPath()%>/static/assets/img/dashboard/download.png"
											class="img img-thumbnail img-responsive download_icon_img"
											alt=""> Export to CSV &nbsp; &nbsp;
										</a>
									</div>
								</div>
							</div>

						</div>
					</div>


					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-11">
							<div class="stat_holder_holder">
								<div class="stat_holder">
									<h3 class="stat_val"><c:if test="${last != (-1) && not empty last}">${sessions.get(0).attempts}</c:if></h3>
									<h3 class="stat_title">Attempts</h3>
								</div>
								<div class="stat_holder">
									<h3 class="stat_val"><c:if test="${last != (-1) && not empty last}">${sessions.get(last).time_taken}</c:if></h3>
									<h3 class="stat_title">Last Attempt Time</h3>
								</div>
								<div class="stat_holder">
									<h3 class="stat_val"><c:if test="${last != (-1) && not empty last}">${sessions.get(last).score_received}</c:if></h3>
									<h3 class="stat_title">Last Attempt Score</h3>

								</div>
								<div class="stat_holder">
									<h3 class="stat_val"><c:if test="${last != (-1) && not empty last}">${sessions.get(0).platform}</c:if></h3>
									<h3 class="stat_title">Platform</h3>
								</div>
							</div>
						</div>
						<div class="col-sm-1"></div>
					</div>


					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<h1 class="page_title_session">Session History</h1>
							<div class="content-table">

								<div class="panel-group"
									style="cursor: default !important; margin-bottom: 0">
									<div class="panel-heading" role="tab" id="headingOne">
										<h4 class="panel-title">
											<a role="button" class="nohover"
												style="cursor: default !important" data-toggle="collapse"
												data-parent="#accordion" href="#collapse"
												aria-expanded="true" aria-controls="collapse}">

												<div class="head-content row">

													<div class="name-holder" style="padding-left: 2%;">
														<h5 class="title">TYPE</h5>
													</div>
													<div class="emp-id-holder">
														<h5 class="title">PLATFORM</h5>
													</div>
													<div class="date-holder">
														<h5 class="title">TIME TAKEN</h5>
													</div>
													<div class="type-holder">
														<h5 class="title">SCORE</h5>
													</div>

													<div class="menu-img-holder"></div>
													<div class="updown-arrow-holder"
														style="cursor: pointer !important; visibility: hidden;"
														id="filter_toggle">
														<img
															src="<%=request.getContextPath()%>/static/assets/img/dashboard/filter.png"
															class="img img-thumbnail img-responsive filter_image">
													</div>

												</div>
											</a>
										</h4>
									</div>
								</div>
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<c:forEach var="item" items="${sessions}" varStatus="loop">
										<div class="panel panel-default ">
											<div class="panel-heading" role="tab" id="headingOne">
												<h4 class="panel-title">
													<a role="button" class="nohover" data-toggle="collapse"
														data-parent="#accordion" href="#collapse3${loop.index}"
														aria-expanded="true"
														aria-controls="collapse3${loop.index}">

														<div class="head-content row">

															<div class="name-holder">
																<h4 class="avatar_name" style="padding-left: 5%;">
																	${item.type}</h4>
															</div>
															<div class="emp-id-holder">
																<h5>${item.platform}</h5>
															</div>
															<div class="date-holder">
																<h5>${item.time_taken}</h5>
															</div>
															<div class="type-holder">
																<h5>${item.score_received}</h5>
															</div>

															<div class="menu-img-holder"></div>
															<div class="updown-arrow-holder">
																<img
																	src="<%=request.getContextPath()%>/static/assets/img/sidebar/arrow_head.png"
																	class="img img-thumbnail img-responsive arrow_head"
																	data-toggle="collapse" href="#collapse3${loop.index}"
																	aria-expanded="true"
																	aria-controls="collapse3${loop.index}">
															</div>
														</div>
													</a>
												</h4>
											</div>
											<div id="collapse3${loop.index}"
												class="panel-collapse collapse " role="tabpanel"
												aria-labelledby="heading3">
												<div class="panel-body">
													<div class="row">
														<div class="session-id-holder">
															<h3 class="session_id">Session ID : ${item.id}</h3>
														</div>
														<div class="time-log-holder">
															<h3 class="time_log">${item.created_at}</h3>
														</div>
													</div>
													<div class="row">
														<c:if test="${item.type == 'Training'}">
															<div class="content-holder">
																<div class="content-1-holder">
																	<h3 class="table_value">${item.time_taken}</h3>
																	<h2 class="table_sub_content">Total Time</h2>
																</div>
																<div class="content-2-holder">
																	<h3 class="table_value">${item.time_taken_module_1}</h3>
																	<h2 class="table_sub_content">Module 1</h2>
																</div>
																<div class="content-3-holder">
																	<h3 class="table_value">${item.time_taken_module_2}</h3>
																	<h2 class="table_sub_content">Module 2</h2>
																</div>
																<div class="content-4-holder">
																	<h3 class="table_value">${item.time_taken_module_3}</h3>
																	<h2 class="table_sub_content">Module 3</h2>
																</div>
															</div>
														</c:if>
														<c:if test="${item.type == 'Evaluation'}">
															<div class="content-holder">
																<div class="content-1-holder">
																	<h3 class="table_value">${item.score_received}</h3>
																	<h2 class="table_sub_content">Score</h2>
																</div>
																<div class="content-2-holder">
																	<h3 class="table_value">${item.score_module_1}</h3>
																	<h2 class="table_sub_content">Module 1</h2>
																</div>
																<div class="content-3-holder">
																	<h3 class="table_value">${item.score_module_2}</h3>
																	<h2 class="table_sub_content">Module 2</h2>
																</div>
																<div class="content-4-holder">
																	<h3 class="table_value">${item.score_module_3}</h3>
																	<h2 class="table_sub_content">Module 3</h2>
																</div>
															</div>
														</c:if>
														<div class="view-all-btn-holder">
															<a
																href="<%=request.getContextPath()%>/archivesProcess/${item.id}/1/${trainee.id}"
																class="btn theme-btn-2 pull-right delete_btn viewall_btn">
																Archive </a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
					<div id="dvData">
						<table class="d-none">
							<tr>
								<td>Session ID</td>
								<td>Date</td>
								<td>Time</td>
								<td>Emp ID</td>
								<td>Emp Name</td>
								<td>Platform</td>
								<td>Session Type</td>
								<td>Status</td>
								<td>Time Taken</td>
							</tr>
							<c:forEach var="item" items="${sessions}" varStatus="loop">
								<tr>

									<td>${loop.index}</td>
									<td>${item.date_taken}</td>
									<td>${item.created_at}</td>
									<td>${item.employee_id}</td>
									<td>${item.employee_name}</td>
									<td>${item.platform}</td>
									<td>${item.type}</td>
									<td>${item.session_status}</td>
									<td>${item.time_taken}</td>
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
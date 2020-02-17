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
							<li class="active"><a
								href="<%=request.getContextPath()%>/sessions">Sessions </a></li>
							<li class=""><a href="<%=request.getContextPath()%>/trainee">Trainee
									Record </a></li>
						</ul>
					</div>
					<div class="sidebar_footer">
						<div class="sidebar_menu">
							<ul>
								<li class=""><a
									href="<%=request.getContextPath()%>/archives">Archives</a></li>
								<li><a href="<%=request.getContextPath()%>/login">Logout
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
								<h1 class="page_title">Sessions</h1>
							</div>
							<div class="col-sm-6 ">
								<a class="btn theme-btn detail_download_btn export"> <img
									src="<%=request.getContextPath()%>/static/assets/img/dashboard/download.png"
									class="img img-thumbnail img-responsive download_icon_img"
									alt=""> Export to CSV &nbsp; &nbsp;
								</a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<div class="search_bar_holder">
								<input type="search" name="search" id="searchInput"
									class="form-control-search form-control empty"
									placeholder="Search ">
							</div>

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
													<div class="avatar-holder">
														<img src="http://placehold.it/300x300"
															style="visibility: hidden"
															class="img img-thumbnail avatar">
													</div>
													<div class="name-holder">
														<h5 class="title">NAME</h5>
													</div>
													<div class="emp-id-holder">
														<h5 class="title">EMP ID</h5>
													</div>
													<div class="date-holder">
														<h5 class="title">DATE</h5>
													</div>
													<div class="type-holder">
														<h5 class="title">TYPE</h5>
													</div>

													<div class="menu-img-holder"></div>
													<div class="updown-arrow-holder"
														style="cursor: pointer !important" id="filter_toggle">
														<img
															src="<%=request.getContextPath()%>/static/assets/img/dashboard/filter.png"
															class="img img-thumbnail img-responsive filter_image">
													</div>
													<div class="filter_holder d-none">
														<h2 class="filter_title">FILTERS</h2>
														<h5 class="filter_sub_title">Platform</h5>
														<button class="light-button filter-button"
															data-filter="vr">
															<input type="checkbox" value="vr" id="vr" checked>
															<img
																src="<%=request.getContextPath()%>/static/assets/img/dashboard/check-box-checked.png">
															VR
														</button>
														<br>
														<button class="light-button filter-button"
															data-filter="ar">
															<input type="checkbox" value="ar" id="ar" checked>
															<img
																src="<%=request.getContextPath()%>/static/assets/img/dashboard/check-box-checked.png">
															AR
														</button>

														<h5 class="filter_sub_title">Session Type</h5>
														<button class="light-button filter-button"
															data-filter="training">
															<input type="checkbox" value="training" id="training"
																checked> <img
																src="<%=request.getContextPath()%>/static/assets/img/dashboard/check-box-checked.png">
															Training
														</button>
														<br>
														<button class="light-button filter-button"
															data-filter="test">

															<input type="checkbox" value="test" id="test" checked>
															<img
																src="<%=request.getContextPath()%>/static/assets/img/dashboard/check-box-checked.png">
															Evaluation
														</button>
														<h5 class="filter_sub_title">Date</h5>
														<span class=" calender-icon"><img
															src="<%=request.getContextPath()%>/static/assets/img/dashboard/calender.png"
															alt=""></span> <input type="text" name="daterange"
															class="date-picker" />
													</div>
												</div>
											</a>
										</h4>
									</div>
								</div>
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<c:forEach var="session" items="${sessions}" varStatus="loop">
										<div class="panel panel-default filter ar training"
											data-date="23-11-2018">
											<div class="panel-heading" role="tab" id="headingOne">
												<h4 class="panel-title">


													<div class="head-content row">
														<a role="button" class="nohover" data-toggle="collapse"
															data-parent="#accordion" href="#collapse${loop.index}"
															aria-expanded="true"
															aria-controls="collapse${loop.index}">
															<div class="avatar-holder">
																<c:if test="${not empty session.pictureBase64}">
																	<img src="data:image/jpeg;base64,${session.pictureBase64}"
																			class="img img-thumbnail avatar" />
																</c:if>
																<c:if test="${empty session.pictureBase64}">
																	<img class="img img-thumbnail avatar"  src="<%=request.getContextPath()%>/static/assets/img/profile/no-profile.jpeg" />
																</c:if>																
															</div>
															<div class="name-holder">
																<h4 class="avatar_name">${session.employee_name}</h4>
															</div>
															<div class="emp-id-holder">
																<h5>${session.employee_id}</h5>
															</div>
															<div class="date-holder">
																<h5>${session.date_taken}</h5>
															</div>
															<div class="type-holder">
																<h5>${session.type}</h5>
															</div>
														</a>

														<div class="menu-img-holder" data-toggle="collapse"
															href="#collapse${loop.index}" aria-expanded="true"
															aria-controls="collapse${loop.index}">
															<div class="dropdown">
																<button
																	class="btn dropdown-toggle download_btn content-menu-btn d-none"
																	type="button" data-toggle="dropdown">
																	<img
																		src="<%=request.getContextPath()%>/static/assets/img/dashboard/menu.png">
																</button>
																<ul class="dropdown-menu add_record">
																	<li><a href="<%=request.getContextPath()%>/archivesProcess/${session.id}/1/0"
																		class="dropdown_menu_item delete_btn" data-id="3">Archive
																			Session</a></li>
																</ul>
															</div>
														</div>
														<div class="updown-arrow-holder">
															<img
																src="<%=request.getContextPath()%>/static/assets/img/sidebar/arrow_head.png"
																class="img img-thumbnail img-responsive arrow_head"
																data-toggle="collapse" href="#collapse${loop.index}"
																aria-expanded="true"
																aria-controls="collapse${loop.index}">
														</div>
													</div>
													</a>
												</h4>
											</div>
											<div id="collapse${loop.index}"
												class="panel-collapse collapse " role="tabpanel"
												aria-labelledby="heading3">
												<div class="panel-body">
													<div class="row">
														<div class="session-id-holder">
															<h3 class="session_id">Session ID : ${loop.index}</h3>
														</div>
														<div class="time-log-holder">
															<h3 class="time_log">${session.time_taken}</h3>
														</div>
													</div>
													<div class="row">
													<c:if test="${session.type == 'Training'}">
														<div class="content-holder">
															<div class="content-1-holder">
																<h3 class="table_value">${session.time_taken}</h3>
																<h2 class="table_sub_content">Total Time</h2>
															</div>
															<div class="content-2-holder">
																<h3 class="table_value">${session.time_taken_module_1}</h3>
																<h2 class="table_sub_content">Module 1</h2>
															</div>
															<div class="content-3-holder">
																<h3 class="table_value">${session.time_taken_module_2}</h3>
																<h2 class="table_sub_content">Module 2</h2>
															</div>
															<div class="content-4-holder">
																<h3 class="table_value">${session.time_taken_module_3}</h3>
																<h2 class="table_sub_content">Module 3</h2>
															</div>
														</div>
													</c:if>
													<c:if test="${session.type == 'Evaluation'}">
														<div class="content-holder">
															<div class="content-1-holder">
																<h3 class="table_value">${session.score_received}</h3>
																<h2 class="table_sub_content">Score</h2>
															</div>
															<div class="content-2-holder">
																<h3 class="table_value">${session.score_module_1}</h3>
																<h2 class="table_sub_content">Module 1</h2>
															</div>
															<div class="content-3-holder">
																<h3 class="table_value">${session.score_module_2}</h3>
																<h2 class="table_sub_content">Module 2</h2>
															</div>
															<div class="content-4-holder">
																<h3 class="table_value">${session.score_module_3}</h3>
																<h2 class="table_sub_content">Module 3</h2>
															</div>
														</div>
													</c:if>
														<div class="view-all-btn-holder">
															<a href="detail/${session.employee_id}"
																class="btn theme-btn-2 pull-right viewall_btn"> View
																All</a>
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
				</div>
				<div id="dvData">
					<table class="d-none">
						<c:forEach var="item" items="${sessions}" varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td>${item.date_taken}</td>
								<td>${item.created_at}</td>
								<td>${item.employee_id}</td>
								<td>${item.employee_name}</td>
								<td>${item.platform}</td>
								<td>${item.type}</td>
								<td>${item.session_status}</td>
								<td>${item.time_taken}</td>
								<td>${item.time_taken_module_1}</td>
								<td>${item.time_taken_module_2}</td>
								<td>${item.time_taken_module_3}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<script>
					$(function() {
						$('input[name="daterange"]')
								.daterangepicker(
										{
											opens : 'left'
										},
										function(start, end, label) {

											// alert("A new date selection was made: " + start.format('YYYY MMM DD') + ' to ' + end.format('YYYY MMM DD'));
											var start = start
													.format('DD MMM YYYY');
											var end = end.format('DD MMM YYYY');
											$('.panel.panel-default.filter')
													.css('display', 'none');
											// alert(startDate);
											// console.log(start);
											// var date=(dateFns.eachDay(start,end));

											var start = new Date(start);
											var end = new Date(end);
											var newend = end.setDate(end
													.getDate() + 1);
											var end = new Date(newend);
											var newend = end.setDate(end
													.getDate() + 1);
											var end = new Date(newend);
											while (start < end) {
												// ISO Date format
												function convert(str) {
													var date = new Date(str), mnth = ("0" + (date
															.getMonth() + 1))
															.slice(-2), day = ("0" + date
															.getDate())
															.slice(-2);
													return [ day, mnth,
															date.getFullYear() ]
															.join("-");
												}

												var value = convert(start);

												$('[data-date="' + value + '"]')
														.css('display', 'block');

												var newDate = start
														.setDate(start
																.getDate() + 1);
												start = new Date(newDate);

											}
										});
					});
				</script>

			</div>
		</div>
		</div>
	</section>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/assets/js/custom.js"></script>
</body>
</html>
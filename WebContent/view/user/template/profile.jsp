
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/view/user/template" var="url" />


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Online Book Store</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="${url}/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/themify-icons.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="${url}/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="${url}/css/style.css" type="text/css">

<style>
body {
	/* font-family: Georgia, 'Times New Roman', Times, serif; */
	font-size: 18px;
}

.col-xs-6 p {
	font-family: "Muli", sans-serif;
	font-style: oblique;
	font-size: 18px;
	color: #4e4c48;
	/* font-family: Georgia, 'Times New Roman', Times, serif; */
}

.col-xs-6 h4 {
	color: #e7ab3c;
}

.col-sm-9 a {
	color: #e7ab3c;
	font-family: "Muli", sans-serif;
	font-size: 25px;
}

table {
	font-family: "Muli", sans-serif;
	border-collapse: collapse;
	width: 100%;
	margin-top: 20px;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #e7ab3c;
}

.container {
	width: 100%;
}

.nav-tabs {
	border-bottom: 1px solid #ddd;
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: rgb(221, 221, 221);
}

.row {
	margin-top: 28px;
	margin-bottom: 30px;
}

.col-xs-6 hr {
	margin-top: -20px;
	border: 0.3px solid #e9eaec;
}

.col-sm-9 li {
	font-family: "Muli", sans-serif;
	font-weight: bold;
	font-size: 24px;
}

.btn btn-lg btn-success {
	color: #e7ab3c;
}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	if (session.getAttribute("username") == null) {
		response.sendRedirect(request.getContextPath() + "/view/user/login");
	}
	%>


	<header class="header-section">
		<div class="header-top">
			<div class="container">
				<div class="ht-left">
					<div class="mail-service">
						<i class=" fa fa-envelope"></i> onl.bookstore@gmail.com
					</div>
					<div class="phone-service">
						<i class=" fa fa-phone"></i> +65 11.188.888
					</div>
				</div>
				<div class="ht-right">
					<c:choose>
						<c:when test="${sessionScope.username == null }">
							<a href="${pageContext.request.contextPath}/view/user/login"
								class="login-panel"><i class="fa fa-user"></i>Login</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/view/logout"
								class="login-panel"><i class="fa fa-user"></i>Logout</a>
						</c:otherwise>
					</c:choose>
					<div class="lan-selector">
						<select class="language_drop" name="countries" id="countries"
							style="width: 300px;">
							<option value='yt' data-image="${ url}/img/flag-2.jpg"
								data-imagecss="flag yt" data-title="English">English</option>
							<option value='yu' data-image="${ url}/img/flag-1.jpg"
								data-imagecss="flag yu" data-title="Bangladesh">VietNam
							</option>
						</select>
					</div>
					<div class="top-social">
						<a href="#"><i class="ti-facebook"></i></a> <a href="#"><i
							class="ti-twitter-alt"></i></a> <a href="#"><i
							class="ti-linkedin"></i></a>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="inner-header">
				<div class="row">
					<div class="col-lg-2 col-md-2">
						<div class="logo">
							<a href="${pageContext.request.contextPath}/view/user/homepage">
								<img src="${url}/img/logo.png" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-7 col-md-7">
						<form
							action="${pageContext.request.contextPath}/view/user/search-key-topic"
							class="input-group" method="get">
							<div class="advanced-search">

								<select class="sorting" name="option-topic">
									<option value="default">All</option>
									<c:forEach items="${listcategory}" var="cate">
										<option value="${cate.name}"
											style="background-color: #ffc14d;">${cate.name}</option>
									</c:forEach>
								</select> <input type="text" size="50" style="height: 50px;"
									placeholder="What kinds of books do you need?"
									name="search-key">
								<button style="height: 50px; background-color: #ffc14d;width : 50px;">
									<i class="ti-search" style="color: white; "></i>
								</button>
							</div>
						</form>
					</div>
					<div class="col-lg-3 text-right col-md-3">
						<ul class="nav-right">
							<li class="heart-icon"><a href="#"> <i
									class="icon_heart_alt"></i> <span>1</span>
							</a></li>


							<li class="cart-icon"><a
								href="${pageContext.request.contextPath}/view/user/shopping-cart">
									<i class="icon_bag_alt"></i> 
							</a>
								<div class="cart-hover">
									<div class="select-items">
										<table>
											<tbody>
												<c:forEach items="${order.items}" var="listitem">
													<tr>
														<td class="si-pic"><img
															src="${pageContext.request.contextPath}/${listitem.product.urlTemp}"
															alt=""
															style="width: 110px; height: 67px; object-fit: cover; border: 1px solid #fff;"></td>
														<td class="si-text">
															<div class="product-selected">
																<p>$${listitem.product.price}</p>
																<h6>${listitem.product.name}</h6>
															</div>
														</td>

													</tr>
												</c:forEach>


											</tbody>
										</table>
									</div>
									<div class="select-total">
										<span>total:</span>
										<h5>$${order.sumPrice}</h5>
									</div>


									<div class="select-button">
										<a
											href="${pageContext.request.contextPath}/view/user/shopping-cart"
											class="primary-btn view-card">VIEW CARD</a> <a
											href="${pageContext.request.contextPath}/view/user/checkout"
											class="primary-btn checkout-btn">CHECK OUT</a>
									</div>
								</div></li>
							<li class="cart-price">$${order.sumPrice}</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="nav-item">
			<div class="container">
				<div class="nav-depart">
					<div class="depart-btn">
						<i class="ti-menu"></i> <span>All departments</span>
						<ul class="depart-hover">
							<c:forEach items="${listcategory}" var="cate">
								<li><a
									href="${pageContext.request.contextPath}/view/user/shop/view-topic?check-topic=${cate.name}">${cate.name}</a></li>
							</c:forEach>


						</ul>
					</div>
				</div>
				<nav class="nav-menu mobile-menu">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/view/user/homepage">Home</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/user/shop">Shop</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/user/shop/best-sold">Best
								sellers</a></li>
						<li><a href="${ url}/contact.jsp">Contact</a></li>
						<li><a
							href="${pageContext.request.contextPath}/user/new/list"> Blog</a></li>
						<li><a href="#">User</a>
							<ul class="dropdown">
								<li><a
									href="${pageContext.request.contextPath }/view/user/profile">Profile
										User</a></li>
								<li><a
									href="${pageContext.request.contextPath }/view/register">Register</a></li>
								<li><a
									href="${pageContext.request.contextPath }/view/user/login">Login</a></li>
							</ul></li>
					</ul>
				</nav>
				<div id="mobile-menu-wrap"></div>
			</div>
		</div>
	</header>

	<div class="container bootstrap snippet">
		<div class="row">
			<div class="col-sm-9">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">_______HOME________</a></li>
					<li><a data-toggle="tab" href="#messages">EDIT
							PROFILE________</a></li>
					<li><a data-toggle="tab" href="#settings"> HISTORY_______
					</a></li>
				</ul>


				<div class="tab-content">
					<div class="tab-pane active" id="home">
						<hr>

						<div class="col-xs-6">
							<h4>User Name</h4>
							<p id="user-name">${requestScope.userDetail.name}</p>
							<hr>
						</div>
						<div class="col-xs-6">
							<h4>Phone</h4>
							<p id="phone">${requestScope.userDetail.phone}</p>
							<hr>
						</div>

						<div class="col-xs-6">
							<h4>Email</h4>
							<p id="email">${requestScope.userDetail.email}</p>
							<hr>
						</div>
						<div class="col-xs-6">
							<h4>Location</h4>
							<p id="location">${requestScope.userDetail.address}</p>
							<hr>
						</div>
						<div class="col-xs-6">
							<h4>Date of Birth</h4>
							<p id="password">${requestScope.userDetail.dateOfBirth}</p>
							<hr>

						</div>
						<div class="col-xs-6">
							<h4>Created Day</h4>
							<p id="">${requestScope.userDetail.created}</p>
							<hr>

						</div>
					</div>
					<!--/tab-pane-->

					<div class="tab-pane" id="messages">

						<hr>
						<form class="form"
							action="${pageContext.request.contextPath}/view/user/edit"
							method="get" id="registrationForm">

							<div class="form-group">

								<div class="col-xs-6">
									<label for="last_name"><h4>User Name</h4></label> <input
										type="text" class="form-control" name="nameTemp"
										id="last_name" value="${requestScope.userDetail.name}">
								</div>
							</div>

							<div class="form-group">

								<div class="col-xs-6">
									<label for="phone"><h4>Phone</h4></label> <input type="text"
										class="form-control" name="phoneTemp" id="phone"
										value="${requestScope.userDetail.phone}">
								</div>
							</div>


							<div class="col-xs-6">
								<h4>Email</h4>
								<p id="email">${requestScope.userDetail.email}</p>
								<hr>
							</div>

							<div class="form-group">

								<div class="col-xs-6">
									<label for="email"><h4>Location</h4></label> <input type="text"
										class="form-control" name="addressTemp" id="location"
										value="${requestScope.userDetail.address}">
								</div>
							</div>

							<div class="form-group">

								<div class="col-xs-6">
									<label for="password2"><h4>Date of Birth</h4></label> <input
										type="text" class="form-control" name="dobTemp"
										value="${requestScope.userDetail.dateOfBirth}">
								</div>
							</div>

							<div class="col-xs-6">
								<h4>Created Day</h4>
								<p id="">${requestScope.userDetail.created}</p>
								<hr>

							</div>
							<div class="form-group">
								<div class="col-xs-12">
									<br>
									<button class="btn btn-lg btn-success" type="submit">
										<i class="glyphicon glyphicon-ok-sign"></i> Save
									</button>
								</div>
							</div>
						</form>

					</div>

					<div class="tab-pane" id="settings">



						<div class="form-group">

							<table>
								<tr>
									<th>Name Book</th>

									<th>Quantity</th>
									<th>Ordered Date</th>
									<th>Total Money(Same Date)</th>
								</tr>
								<c:forEach items="${listtran}" var="list">

									<tr>
										<td>${list.ordered.name }</td>
										<td>${list.ordered.amount}</td>
										<td>${list.created}</td>
										<td>${list.payment}</td>
									</tr>

								</c:forEach>



							</table>
						</div>


						</form>
					</div>

				</div>
				<!--/tab-pane-->
				<!--/tab-content-->

			</div>
			<!--/col-9-->
		</div>
		<!--/row-->
	</div>


	<!-- Partner Logo Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="/view/user/template/footer/footer.jsp" flush="true" />
</body>
</html>
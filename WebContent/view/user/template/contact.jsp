<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/view/user/template" var="url" />
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Online Book Store</title>


<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="${ url}/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/themify-icons.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="${ url}/css/style.css" type="text/css">
</head>

<body>
	<!-- Page Preloader -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
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
							<a href="${pageContext.request.contextPath}/view/user/homepage"> <img src="${url}/img/logo.png"
								alt="">
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
									<i class="icon_bag_alt"></i> <span>+</span>
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
						<li><a href="${pageContext.request.contextPath}/view/user/shop/best-sold">Best sellers</a>
							</li>
						<li><a href="${ url}/contact.jsp">Contact</a></li>
						<li><a
							href="${pageContext.request.contextPath}/user/new/list">	Blog</a></li>
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
	<!-- Header End -->

	<!-- Breadcrumb Section Begin -->
	<div class="breacrumb-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<a href="#"><i class="fa fa-home"></i> Home</a> <span>Contact</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Section Begin -->



	<!-- Contact Section Begin -->
	<section class="contact-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<div class="contact-title">
						<h4>Contacts Us</h4>

					</div>
					<div class="contact-widget">
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-location-pin"></i>
							</div>
							<div class="ci-text">
								<span>Address:</span>
								<p>km9 Nguyen Trai, Ha Noi University, Trung Van Ward, Nam
									Tu Liem District, Ha Noi</p>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-mobile"></i>
							</div>
							<div class="ci-text">
								<span>Phone:</span>
								<p>+65 11.188.888</p>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-email"></i>
							</div>
							<div class="ci-text">
								<span>Email:</span>
								<p>onl.bookstore@gmail.com</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 offset-lg-1">
					<div class="contact-form">
						<div class="leave-comment">
							<h4>Leave A Comment</h4>
							<p>Our staff will call back later and answer your questions.</p>
							<form action="#" class="comment-form">
								<div class="row">
									<div class="col-lg-6">
										<input type="text" placeholder="Your name">
									</div>
									<div class="col-lg-6">
										<input type="text" placeholder="Your email">
									</div>
									<div class="col-lg-12">
										<textarea placeholder="Your message"></textarea>
										<button type="submit" class="site-btn">Send message</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Contact Section End -->

	<!-- Partner Logo Section Begin -->

	<!-- Partner Logo Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="/view/user/template/footer/footer.jsp" flush="true" />
</body>

</html>
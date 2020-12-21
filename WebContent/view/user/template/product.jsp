<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url value="/view/user/template" var="url" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="">

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
	<!-- Page Preloder -->
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
								<button
									style="height: 50px; background-color: #ffc14d; width: 50px;">
									<i class="ti-search" style="color: white;"></i>
								</button>
							</div>
						</form>
					</div>

					<div class="col-lg-3 text-right col-md-3">
						<ul class="nav-right">
							<li class="heart-icon"><a href="#"> <i
									class="icon_heart_alt"></i> <span>0</span>
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
						<li><a
							href="${pageContext.request.contextPath}/view/user/shop/best-sold">Best
								sellers</a></li>
						<li><a
							href="${pageContext.request.contextPath}/view/user/contact">Contact</a></li>
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
	<!-- Header End -->

	<!-- Breadcrumb Section Begin -->
	<div class="breacrumb-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text product-more">
						<a href="${pageContext.request.contextPath}/view/user/homepage"><i
							class="fa fa-home"></i> Home</a> <a
							href="${pageContext.request.contextPath}/view/user/shop">Shop</a>
						<span>Detail</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Section Begin -->

	<!-- Product Shop Section Begin -->
	<section class="product-shop spad page-details">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="filter-widget">
						<h4 class="fw-title">Author</h4>


						<form
							action="${pageContext.request.contextPath}/view/user/search-author">
							<input type="text" name="check-author" placeholder="Your author?">
							<button>Search</button>
						</form>

					</div>
					<div class="filter-widget"></div>
					<div class="filter-widget">

						<form
							action="${pageContext.request.contextPath}/view/user/shop/view-price"
							method="get">
							<div class="filter-widget">
								<h4 class="fw-title">Price</h4>
								<div class="filter-range-wrap">

									<div class="range-slider">
										<div class="price-input">

											$<input type="text" name="price-start" value="1"> $<input
												type="text" name="price-end" value="100">
										</div>
									</div>

								</div>
								<button class="filter-btn">Filter</button>
							</div>
						</form>


					</div>

					<div class="filter-widget">
						<h4 class="fw-title">Year</h4>
						<div class="fw-tags">
							<a
								href="${pageContext.request.contextPath}/view/user/shop/view-year?viewyear=2020">2020</a>
							<a
								href="${pageContext.request.contextPath}/view/user/shop/view-year?viewyear=2019">2019</a>
							<a
								href="${pageContext.request.contextPath}/view/user/shop/view-year?viewyear=2018">2018</a>
							<a href="${pageContext.request.contextPath}/view/user/shop">Older</a>
						</div>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-6">
							<div class="product-pic-zoom">
								<img class="product-big-img"
									src="${pageContext.request.contextPath}/${productdetail.urlTemp }"
									alt="">
								<div class="zoom-icon">
									<i class="fa fa-search-plus"></i>
								</div>
							</div>

						</div>
						<div class="col-lg-6">
							<div class="product-details">
								<div class="pd-title">
									<span>Short Story</span>
									<h3>${productdetail.name}</h3>
									<a href="#" class="heart-icon"><i class="icon_heart_alt"></i></a>
								</div>
								<div class="pd-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <span>(5)</span>
								</div>
								<div class="pd-desc">
									<%-- <p>${productdetail.description}</p> --%>
									<h4>
										$${productdetail.price} <span>${productdetail.discount}%</span>
									</h4>
								</div>



								<form
									action="${pageContext.request.contextPath}/view/user/update-quantity"
									method="get">
									ID: <input type="text" value="${productdetail.product_id}"
										name="check_id" size="2">
									<div>
										Status: <input type="text" value="${productdetail.quantity }"
											name="check_id" size="2" disabled="disabled">
									</div>


									<div class="quantity">
										<div class="pro-qty">
											<input type="text" value="1" name="purchase-quantity">

										</div>

										<c:choose>
											<c:when test="${ requestScope.checkSessionExisted =='existed'}">

												<button class="primary-btn pd-cart" style="size: 10">Add
													To Cart</button>
											</c:when>

											<c:otherwise>
												<a class="primary-btn pd-cart" style="size: 10"
													href="${pageContext.request.contextPath}/view/user/add-cart?id=${productdetail.product_id}"><i
													class="icon_bag_alt"></i></a>
											</c:otherwise>

										</c:choose>



									</div>






								</form>
								<ul class="pd-tags">
									<li><span>CATEGORIES</span>: ${productdetail.topic}</li>
									<li><span>TAGS</span>: ${productdetail.author}</li>
								</ul>
								<div class="pd-share">

									<div class="pd-social">
										<a href="#"><i class="ti-facebook"></i></a> <a href="#"><i
											class="ti-twitter-alt"></i></a> <a href="#"><i
											class="ti-linkedin"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="product-tab">
						<div class="tab-item">
							<ul class="nav" role="tablist">
								<li><a class="active" data-toggle="tab" href="#tab-1"
									role="tab">DESCRIPTION</a></li>
								<li><a data-toggle="tab" href="#tab-2" role="tab">SPECIFICATIONS</a>
								</li>
								<li><a data-toggle="tab" href="#tab-3" role="tab">Customer
										Reviews (02)</a></li>
							</ul>
						</div>
						<div class="tab-item-content">
							<div class="tab-content">
								<div class="tab-pane fade-in active" id="tab-1" role="tabpanel">
									<div class="product-content">
										<div class="row">
											<div class="col-lg-7">
												<h5>Introduction</h5>
												<p>${productdetail.description}</p>

											</div>
											<div class="col-lg-5">
												<img src="img/select-product-6.jpg" alt="">
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="tab-2" role="tabpanel">
									<div class="specification-table">
										<table>
											<tr>
												<td class="p-catagory">Customer Rating</td>
												<td>
													<div class="pd-rating">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <span>(5)</span>
													</div>
												</td>
											</tr>
											<tr>
												<td class="p-catagory">Price</td>
												<td>
													<div class="p-price">$${productdetail.price}</div>
												</td>
											</tr>
											<tr>
												<td class="p-catagory">Add To Cart</td>
												<td>
													<div class="cart-add">+ add to cart</div>
												</td>
											</tr>
											<tr>
												<td class="p-catagory">Availability</td>
												<td>
													<div class="p-stock">${productdetail.quantity}in
														stock</div>
												</td>
											</tr>



										</table>
									</div>
								</div>
								<div class="tab-pane fade" id="tab-3" role="tabpanel">
									<div class="customer-review-option">
										<h4>2 Comments</h4>
										<div class="comment-option">
											<div class="co-item">
												<div class="avatar-pic">
													<img src="img/product-single/avatar-1.png" alt="">
												</div>
												<div class="avatar-text">
													<div class="at-rating">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star-o"></i>
													</div>
													<h5>
														Brandon Kelley <span>27 Aug 2019</span>
													</h5>
													<div class="at-reply">Nice !</div>
												</div>
											</div>
											<div class="co-item">
												<div class="avatar-pic">
													<img src="img/product-single/avatar-2.png" alt="">
												</div>
												<div class="avatar-text">
													<div class="at-rating">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star-o"></i>
													</div>
													<h5>
														Roy Banks <span>1 July 2020</span>
													</h5>
													<div class="at-reply">Good !</div>
												</div>
											</div>
											<div class="co-item">
												<div class="avatar-pic">
													<img src="img/insta-4.jpg" alt="">
												</div>
												<div class="avatar-text">
													<div class="at-rating">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i>
													</div>
													<h5>
														Roy Banks <span>10 July 2020</span>
													</h5>
													<div class="at-reply">SÃ¡ch ráº¥t hay vÃ  Ã½ nghÄ©a</div>
												</div>
											</div>
										</div>
										<div class="personal-rating">
											<h6>Your Ratind</h6>
											<div class="rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o"></i>
											</div>
										</div>
										<div class="leave-comment">
											<h4>Leave A Comment</h4>
											<form action="#" class="comment-form">
												<div class="row">
													<div class="col-lg-6">
														<input type="text" placeholder="Name">
													</div>
													<div class="col-lg-6">
														<input type="text" placeholder="Email">
													</div>
													<div class="col-lg-12">
														<textarea placeholder="Messages"></textarea>
														<button type="submit" class="site-btn">Send
															message</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Shop Section End -->

	<!-- Related Products Section End -->
	<div class="related-products spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Related Products</h2>
					</div>
				</div>
			</div>
			<div class="row">

				<c:forEach items="${listrelate}" var="product">

					<div class="col-lg-4 col-sm-6">
						<div class="product-item">
							<div class="pi-pic">
								<img src="${pageContext.request.contextPath}/${product.urlTemp}"
									alt=""
									style="width: 270px; height: 302px; object-fit: cover; border: 1px solid #fff;">
								<div class="sale pp-sale">Sale off</div>
								<div class="icon">
									<i class="icon_heart_alt"></i>
								</div>
								<ul>
									<li class="w-icon active"><a
										href="${pageContext.request.contextPath}/view/user/product-detail?id=${product.product_id}"><i
											class="icon_bag_alt"></i></a></li>
									<li class="quick-view"><a
										href="${pageContext.request.contextPath}/view/user/product-detail?id=${product.product_id}">+
											Quick View</a></li>
								</ul>
							</div>
							<div class="pi-text">
								<div class="catagory-name">Short Story</div>
								<a
									href="${pageContext.request.contextPath}/view/user/product-detail?id=${product.product_id}">
									<h5>${product.name}</h5>
								</a>
								<div class="product-price">
									${product.price}<span>${product.discount}%</span>
								</div>
							</div>
						</div>

					</div>

				</c:forEach>

			</div>
		</div>
	</div>

	<!-- Partner Logo Section End -->

	<!-- Footer Section Begin -->
	<jsp:include page="/view/user/template/footer/footer.jsp" flush="true" />
</body>

</html>
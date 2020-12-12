<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

if (session.getAttribute("admin-username") == null) {
	response.sendRedirect(request.getContextPath() + "/admin/login");
}
%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">
		<div class="card mt-3">
			<div class="card-content">
				<div class="row row-group m-0">
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								3 <span class="float-right"><i
									class="fa fa-shopping-cart"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Order/Week<span class="float-right">+4.2% <i
									class="zmdi zmdi-long-arrow-up"></i></span>
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								230.000 <span class="float-right">VNĐ</span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Profit<span class="float-right">+1.2% <i
									class="zmdi zmdi-long-arrow-up"></i></span>
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								25 <span class="float-right"><i class="fa fa-eye"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Traffic<span class="float-right">+5.2% <i
									class="zmdi zmdi-long-arrow-up"></i></span>
							</p>
						</div>
					</div>
					<div class="col-12 col-lg-6 col-xl-3 border-light">
						<div class="card-body">
							<h5 class="text-white mb-0">
								3 <span class="float-right"><i class="fa fa-envira"></i></span>
							</h5>
							<div class="progress my-3" style="height: 3px;">
								<div class="progress-bar" style="width: 55%"></div>
							</div>
							<p class="mb-0 text-white small-font">
								Sold<span class="float-right">+2.2% <i
									class="zmdi zmdi-long-arrow-up"></i></span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</div>
<a href="javaScript:void();" class="back-to-top"><i
	class="fa fa-angle-double-up"></i> </a>
<div class="right-sidebar">
	
	<div class="right-sidebar-content">
		<p class="mb-0">Background</p>
		<hr>
		<ul class="switcher">
			<li id="theme1"></li>
			<li id="theme2"></li>
			<li id="theme3"></li>
			<li id="theme4"></li>
			<li id="theme5"></li>
			<li id="theme6"></li>
		</ul>
		<p class="mb-0">Gradient</p>
		<hr>
		<ul class="switcher">
			<li id="theme7"></li>
			<li id="theme8"></li>
			<li id="theme9"></li>
			<li id="theme10"></li>
			<li id="theme11"></li>
			<li id="theme12"></li>
			<li id="theme13"></li>
			<li id="theme14"></li>
			<li id="theme15"></li>
		</ul>
	</div>
</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />
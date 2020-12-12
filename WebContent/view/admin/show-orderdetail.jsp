<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<!--End Row-->


		<div class="row">

			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">The Details of Order</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>

										<th scope="col">Username</th>
										<th scope="col">Product Name</th>
										<th scope="col">Price</th>

										<th scope="col">Quantity</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orderedlist}" var="orderedlist">
										<tr>


											<td>${orderedlist.username}</td>
											<td>${orderedlist.name}</td>
											<td>${orderedlist.price}</td>
											<td>${orderedlist.amount}</td>

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
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />
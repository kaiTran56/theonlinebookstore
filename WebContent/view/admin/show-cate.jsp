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
				<button class="add-catalog">
					<a href="${pageContext.request.contextPath}/admin/cate/add">Add
						Catalog</a>
				</button>
			</div>
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">List Topic</h5>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>

										<th scope="col">Name</th>
										<th scope="col">Parent</th>
										<th scope="col">Action</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${catelist}" var="cate">
										<tr>

											<td>${cate.name}</td>
											<td><c:choose>
													<c:when test="${cate.parent_id == 0}">
														<c:out value="NULL" />
													</c:when>
													<c:otherwise>
														<c:out value="new product" />
													</c:otherwise>
												</c:choose></td>
											<td>
												<button class="btn btn-danger">
													<a
														href="${pageContext.request.contextPath}/admin/cate/delete?id=${cate.catalog_id}">Remove</a>
												</button>

												<button class="btn btn-success">
													<a
														href="${pageContext.request.contextPath}/admin/cate/edit?id=${cate.catalog_id}">Edit</a>
												</button>
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
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />
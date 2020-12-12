<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Add Topic</div>
						<hr>
						<form action="${pageContext.request.contextPath}/admin/cate/add"
							method="post">

							<div class="form-group">
								<label for="input-3">ID</label> <input type="text"
									class="form-control" id="input-3" placeholder="ID"
									name="cate-id">
							</div>
							<div class="form-group">
								<label for="input-1">Name of Topic</label> <input type="text"
									class="form-control" id="input-1" placeholder="Name"
									name="cate-name">
							</div>
							<div class="form-group">
								<label for="input-2">Parent of Topic</label>
								<div>
									<select class="form-control valid" id="input-6" required
										aria-invalid="false">
										<option value="1">New Product</option>
									</select>
								</div>
							</div>
							<div class="form-footer">

								<button type="submit" class="btn btn-success">
									<i class="fa fa-check-square-o"></i> Add
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="overlay toggle-menu"></div>
	</div>
</div>

<jsp:include page="./footer/footer.jsp" flush="true" />
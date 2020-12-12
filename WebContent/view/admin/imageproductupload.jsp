<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Add Image of Product</div>
						<hr>
						<%-- <form action="${pageContext.request.contextPath}/admin/image/upload"
							method="post">

							<div class="form-group">
								<label for="input-3">Image</label> 
								 <input type="file"
									class="form-control" id="input-18" name="new-image_link"
									value="select images..." /> 
									<input type="submit"
									value="start upload" />
								<div class="form-group"></div>
							</div>
						</form> --%>
						<form method="post"
							action="${pageContext.request.contextPath}/admin/image/upload/product"
							encType="multipart/form-data">
							<div class="form-group">
								<label for="input-3">Image</label> <input type="file"
									class="form-control" id="input-18" name="new-image_link"
									value="select images..." />
							</div>

							<div class="form-footer">

								<button class="btn btn-danger">
									<i class="fa fa-times"></i><a
										href="${pageContext.request.contextPath}/admin/list-product">Cancel</a>
								</button>
								<button type="submit" class="btn btn-success">
									<i class="fa fa-check-square-o"></i>Add
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
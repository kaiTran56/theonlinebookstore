<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />
<div class="content-wrapper">
	<div class="container-fluid">

		<div class="row mt-3">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Edit News</div>
						<hr>
						<form action="${pageContext.request.contextPath}/admin/new/edit"
							method="post">
							
							<div class="form-group">
								<label for="input-2">Title</label> <input type="text"
									class="form-control" id="input-2" value="${boardnew.title}"
									name="new-title">
							</div>
							<div class="form-group">
								<label for="input-3">Content</label>
								<textarea class="form-control" rows="4" id="input-17"
									name="new-content">${boardnew.content}</textarea>
							</div>
							<div class="form-group">
								<label for="input-2">Image</label> <input type="text"
									class="form-control" id="input-10"
									value="${boardnew.image_link}" name="new-image_link">
							</div>
							<div class="form-group">
								<label for="input-4">Author</label>
								<div>
									<select class="form-control valid" id="input-4"
										name="new-author"" >
										<option>TranQuyet</option>
										<option>TranKai</option>
										<option></option>
										<option></option>
										<option></option>
									</select>
								</div>
							</div>
							
							<div class="form-footer">
								<button class="btn btn-danger">
									<a href="${pageContext.request.contextPath}/admin/list-boardnew">Cancel</a>
								</button>
								<button class="btn btn-success">Update</button>
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
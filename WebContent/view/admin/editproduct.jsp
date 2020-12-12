<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Start header section -->
<jsp:include page="./header/header.jsp" flush="true" />

<div class="content-wrapper">
	<div class="container-fluid">
		<div class="row mt-3">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="card-title">Edit Product</div>
						<hr>
						<form method="post"
							action="${pageContext.request.contextPath}/admin/product/edit">

							<div class="form-group">
								<label for="input-1">ID</label> <input type="text"
									class="form-control" readonly="readonly" id="input-1" "Mã sản
									phẩm" name="product-id" value="${product.product_id}">
							</div>

							<div class="form-group">
								<label for="input-1">Name</label> <input type="text"
									class="form-control" id="input-1" "Tên sản
									phẩm" name="product-name" value="${product.name}">
							</div>
							<div class="form-group">
								<label for="input-1">Author</label> <input type="text"
									class="form-control" id="input-1" name="product-author"
									value="${product.author}">
							</div>


							<div class="form-group">
								<label for="input-2">Topic</label>
								<div>
									<select class="form-control valid" id="input-6"
										name="product-cate" aria-invalid="false">
										<c:forEach items="${catelist}" var="cate">
											<option value="${cate.catalog_id }" selected="selected">${cate.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="input-1">Price</label> <input type="text"
									class="form-control" id="input-1" "Giá" name="product-price"
									value="${product.price}">
							</div>

							<div class="form-group">
								<label for="input-2">Status</label>
								<div>
									<select class="form-control valid" id="input-6"
										name="product-status" required aria-invalid="false">
										<option value="1">On</option>
										<option value="0">Out</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="input-2">Sale</label>
								<div class="input-group">
									<input type="text" class="form-control"
										"Giảm ... %" name="product-discount"
										value="${product.discount}">
									<div class="input-group-append">
										<button class="btn btn-light" type="button">%</button>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="input-1">Quantity</label> <input type="text"
									class="form-control" id="input-1" "Giá" name="product-quantity"
									value="${product.quantity}">
							</div>
							<div class="form-group">
								<label for="input-2" class="col-form-label">Description</label>
								<div>
									<textarea class="form-control" rows="4" id="input-17"
										name="product-desc">${product.description}</textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="input-1">Image</label> <input type="text"
									class="form-control" id="input-1" readonly="readonly"
									placeholder="Price" name="product-image"
									value="${product.image_link }">
							</div>
							<div class="form-footer">
								<button class="btn btn-danger">
									<a href="${pageContext.request.contextPath}/admin/list-product">Cancels</a>
								</button>

								<button type="submit" class="btn btn-success">Update</button>
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
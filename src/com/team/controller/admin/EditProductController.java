package com.team.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Category;
import com.team.model.Product;

/**
 * Servlet implementation class EditProductController
 */

public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goEditProduct(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doEditProduct(request, response);
	}

	protected void goEditProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> listCate = new CategoryDaoImpl().getAll();
		request.setAttribute("catelist", listCate);
		int id = Integer.parseInt(request.getParameter("id"));
		Product productTemp = new ProductDaoImpl().get(id);
		request.setAttribute("product", productTemp);
		request.getRequestDispatcher("/view/admin/editproduct.jsp").forward(request, response);

	}

	protected void doEditProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product-id"));

		String name = request.getParameter("product-name");

		String authorTemp = request.getParameter("product-author");
		System.out.println("Author: " + authorTemp);
		int catalog_id = Integer.parseInt(request.getParameter("product-cate"));
		double price = Double.parseDouble(request.getParameter("product-price"));
		String status = request.getParameter("product-status");
		int discount = Integer.parseInt(request.getParameter("product-discount"));
		int quantity = Integer.parseInt(request.getParameter("product-quantity"));
		String description = request.getParameter("product-desc");
		String image_link = request.getParameter("product-image");
		LocalDateTime created = LocalDateTime.now();

		Product product = new Product(product_id, catalog_id, name, authorTemp, price, status, description, discount,
				image_link, created, quantity);
		product.setAuthor(authorTemp);
		System.out.println("PRoduct: " + product.toString() + " Author: " + product.getAuthor());
		new ProductDaoImpl().edit(product);
		response.sendRedirect(request.getContextPath() + "/admin/list-product");
	}

}

package com.team.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.model.Category;
import com.team.model.Product;

/**
 * Servlet implementation class AddProductController
 */

public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goAddProduct(request, response);
	}

	protected void goAddProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCate = new CategoryDaoImpl().getAll();
		request.setAttribute("catelist", listCate);
		request.getRequestDispatcher("/view/admin/addproduct.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAddProduct(request, response);
	}

	protected void doAddProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int product_id = Integer.parseInt(request.getParameter("product-id").trim());

		String name = request.getParameter("product-name");
		String author = request.getParameter("product-author");
		int catalog_id = Integer.parseInt(request.getParameter("product-cate"));
		double price = Double.parseDouble(request.getParameter("product-price").trim());
		String status = request.getParameter("product-status");
		int discount = Integer.parseInt(request.getParameter("product-discount").trim());
		String description = request.getParameter("product-desc");
		LocalDateTime created = LocalDateTime.now();
		int quantity = Integer.parseInt(request.getParameter("product-quantity").trim());

		Product product = new Product(catalog_id, name, author, price, status, description, discount, created,
				quantity);

		session.setAttribute("productTemp", product);
		System.out.println("Product-id: " + product.getProduct_id());
		session.setAttribute("idproduct", product_id);
		response.sendRedirect(request.getContextPath() + "/view/admin/imageproductupload.jsp");
	}

}

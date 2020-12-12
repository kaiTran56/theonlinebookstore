package com.team.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Category;
import com.team.model.Product;

/**
 * Servlet implementation class ProductDetailController
 */

public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String check_id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = new CategoryDaoImpl().getAll();

		request.setAttribute("listcategory", listCategory);
		

		/*
		 * show the detail information about product by product_id
		 */

		check_id = request.getParameter("id");

		Product product = new ProductDaoImpl().get(Integer.parseInt(check_id));
		request.setAttribute("productdetail", product);

		/*
		 * show the related book
		 * 
		 */
		List<Product> listRelate = new ProductDaoImpl().getAll().stream().limit(3).collect(Collectors.toList());
		request.setAttribute("listrelate", listRelate);

		request.getRequestDispatcher("/view/user/template/product.jsp").forward(request, response);
	}

}

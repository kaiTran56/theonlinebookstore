package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Product;

/**
 * Servlet implementation class SortByYearController
 */

public class SortByYearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SortByYearController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doSortByYear(request, response);
	}

	protected void doSortByYear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> listProduct = new ProductDaoImpl().getAll();
		listProduct.sort((p1, p2) -> p2.getCreated().compareTo(p1.getCreated()));
		request.setAttribute("listproduct", listProduct);
		request.getRequestDispatcher("/view/user/template/shop.jsp").forward(request, response);

	}

}

package com.team.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Product;

/**
 * Servlet implementation class SearchByAuthorController
 */

public class SearchByAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchByAuthorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doSearchByAuthor(request, response);
	}

	protected void doSearchByAuthor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String author = request.getParameter("check-author");
		List<Product> listProduct = new ProductDaoImpl().getAll().stream().filter(p -> p.getAuthor().equals(author))
				.collect(Collectors.toList());
		request.setAttribute("listproduct", listProduct);
		request.getRequestDispatcher("/view/user/template/shop.jsp").forward(request, response);

	}

}

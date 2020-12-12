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
 * Servlet implementation class ViewByYearController
 */

public class ViewByYearController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewByYearController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doViewByYear(request, response);
	}

	protected void doViewByYear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("viewyear"));

		List<Product> listYear = new ProductDaoImpl().getAll().stream().filter(p -> p.getCreated().getYear() == year)
				.collect(Collectors.toList());

		request.setAttribute("listproduct", listYear);
		request.getRequestDispatcher("/view/user/template/shop.jsp").forward(request, response);
	}

}

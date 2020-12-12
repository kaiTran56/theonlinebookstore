package com.team.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DirectionSortController
 */

public class DirectionSortController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DirectionSortController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String optionSort = request.getParameter("option-sort");
		if (optionSort.equals("author-sort")) {
			response.sendRedirect(request.getContextPath() + "/view/user/shop/sort-name");

		} else if (optionSort.equals("date-sort")) {
			request.getRequestDispatcher("/view/user/shop/sort-year").forward(request, response);
		} else {
			request.getRequestDispatcher("/view/user/shop").forward(request, response);
		}
	}

}

package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.model.Category;

/**
 * Servlet implementation class ErrorHandle
 */

public class ErrorHandleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorHandleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doErrorHandle(request, response);
	}

	protected void doErrorHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = new CategoryDaoImpl().getAll();

		request.setAttribute("listcategory", listCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/template/error.jsp");
		dispatcher.forward(request, response);
	}

}

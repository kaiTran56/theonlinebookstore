package com.team.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.model.Category;

/**
 * Servlet implementation class ListCategoryController
 */

public class ListCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doListBoardnew(request, response);

	}

	protected void doListBoardnew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCate = new CategoryDaoImpl().getAll();
		request.setAttribute("catelist", listCate);
		request.getRequestDispatcher("/view/admin/show-cate.jsp").forward(request, response);
	}

}

package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.model.Category;

/**
 * Servlet implementation class AddCategoryController
 */

public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goAddCate(request, response);
	}

	protected void goAddCate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/admin/addcate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAddCategory(request, response);
	}

	protected void doAddCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int catalog_id = Integer.parseInt(request.getParameter("cate-id"));
		String name = request.getParameter("cate-name");
		new CategoryDaoImpl().insert(new Category(catalog_id, name));
		response.sendRedirect(request.getContextPath() + "/admin/list-cate");
	}

}

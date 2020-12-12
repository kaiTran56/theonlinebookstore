package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.model.Category;

/**
 * Servlet implementation class EditCatalogController
 */

public class EditCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goEditCate(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doEditCategory(request, response);
	}

	protected void goEditCate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int catalog_id = Integer.parseInt(request.getParameter("id"));
		Category categoryTemp = new CategoryDaoImpl().get(catalog_id);
		request.setAttribute("catelist", categoryTemp);
		request.getRequestDispatcher("/view/admin/editcate.jsp").forward(request, response);
	}

	protected void doEditCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int catalog_id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		new CategoryDaoImpl().edit(new Category(catalog_id, name));
		response.sendRedirect(request.getContextPath() + "/admin/list-cate");
	}

}

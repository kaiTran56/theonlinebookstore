package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.AdminDaoImpl;

/**
 * Servlet implementation class RemoveAdminController
 */

public class RemoveAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doRemoveAdmin(request, response);
	}

	protected void doRemoveAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("admin-username");
		new AdminDaoImpl().delete(username);
		response.sendRedirect(request.getContextPath() + "/admin/list-admin");

	}

}

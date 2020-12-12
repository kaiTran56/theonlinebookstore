package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.AdminDaoImpl;
import com.team.model.Admin;

/**
 * Servlet implementation class AddAdminController
 */
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goAddAdmin(request, response);
	}

	protected void goAddAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/admin/addadmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAddAdmin(request, response);
	}

	protected void doAddAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("admin-username");
		String password = request.getParameter("admin-password");

		AdminDaoImpl adminDao = new AdminDaoImpl();
		adminDao.insert(new Admin(username, password));

		response.sendRedirect(request.getContextPath() + "/admin/list-admin");

	}

}

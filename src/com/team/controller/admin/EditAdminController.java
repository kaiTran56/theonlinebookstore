package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.AdminDaoImpl;
import com.team.model.Admin;

/**
 * Servlet implementation class EditAdminController
 */

public class EditAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDaoImpl adminDao;

	@Override
	public void init() throws ServletException {
		adminDao = new AdminDaoImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goEditAdmin(request, response);
	}

	protected void goEditAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("admin-username");
		Admin adminTemp = adminDao.get(username);
		request.setAttribute("admin", adminTemp);
		request.getRequestDispatcher("/view/admin/editadmin.jsp").forward(request, response);
	}

	protected void doEditAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = new Admin(username, password);
		adminDao.Edit(admin);
		response.sendRedirect(request.getContextPath() + "/admin/list-admin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doEditAdmin(request, response);
	}

}

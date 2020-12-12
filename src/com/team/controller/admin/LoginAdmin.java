package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.AdminDaoImpl;
import com.team.model.Admin;

/**
 * Servlet implementation class LoginAdmin
 */

public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("admin-username");
		String password = request.getParameter("admin-password");
		Admin admin = new AdminDaoImpl().getLogin(username, password);
		if (admin == null) {
			request.setAttribute("error", "Wrong password, please try again!");
			request.getRequestDispatcher("/view/admin/login.jsp").forward(request, response);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin-username", admin.getUsername());
			response.sendRedirect(request.getContextPath() + "/admin/homepage");
		}


	}

}

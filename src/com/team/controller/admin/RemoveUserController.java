package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class RemoveController
 */

public class RemoveUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRemoveUser(request, response);

	}

	protected void doRemoveUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String) request.getParameter("user-email");
		new UserDaoImpl().delete(email);
		request.getRequestDispatcher("/admin/list-user").forward(request, response);
	}

}

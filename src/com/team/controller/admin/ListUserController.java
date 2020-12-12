package com.team.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.UserDaoImpl;
import com.team.model.User;

/**
 * Servlet implementation class ListUserController
 */

public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init() throws ServletException {
		userDao = new UserDaoImpl();
	}

	public ListUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doListUser(request, response);
	}

	protected void doListUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUser = this.userDao.getAll();
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/view/admin/user.jsp").forward(request, response);
	}

}

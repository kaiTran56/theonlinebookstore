package com.team.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.UserDaoImpl;
import com.team.model.User;

/**
 * Servlet implementation class Login
 */

public class LoginController extends HttpServlet {
	private UserDaoImpl userDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init() throws ServletException {
		this.userDao = new UserDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goSignUp(request, response);
	}

	protected void goSignUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/user/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCheckLogin(request, response);
	}

	protected void doCheckLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		User user = userDao.login(username, password);
		if (user == null) {
			request.setAttribute("error", "Wrong password, please try again!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/signup.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getEmail());
			response.sendRedirect(request.getContextPath() + "/view/user/homepage");
		}
	}

}

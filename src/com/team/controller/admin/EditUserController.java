package com.team.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.UserDaoImpl;
import com.team.model.User;

/**
 * Servlet implementation class EditUserController
 */

public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		userDao = new UserDaoImpl();
	}

	public EditUserController() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email =  request.getParameter("user-email");
		User userTemp = userDao.get(email);
		request.setAttribute("user", userTemp);
		request.getRequestDispatcher("/view/admin/edituser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("user-name");
		String email = request.getParameter("user-email");
		String phone = request.getParameter("user-phone");
		String dob = request.getParameter("user-dob");
		String address = request.getParameter("user-address");
		String password = request.getParameter("user-password");
		LocalDateTime time = LocalDateTime.now();
		userDao.edit(new User(name, email, phone, dob, address, time));
		userDao.changePassword(email, password);
		response.sendRedirect(request.getContextPath() + "/admin/list-user");
	}

}

package com.team.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.UserDaoImpl;
import com.team.model.User;

/**
 * Servlet implementation class EditProfileUser
 */

public class EditProfileUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfileUserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username");
		LocalDateTime createdTemp = (LocalDateTime) request.getAttribute("createdDay");
		String name = request.getParameter("nameTemp");
		String phone = request.getParameter("phoneTemp");
		String dob = request.getParameter("dobTemp");
		String address = request.getParameter("addressTemp");
		User userTemp = new User(name, email, phone, dob, address, createdTemp);
		if (userTemp != null) {
			new UserDaoImpl().edit(userTemp);
			request.setAttribute("successEdit", "Edit successfully!");
			request.getRequestDispatcher("/view/user/profile").forward(request, response);
		}

	}

}

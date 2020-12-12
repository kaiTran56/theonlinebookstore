package com.team.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.RegisterDao;
import com.team.model.User;

/**
 * Servlet implementation class ResistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public RegistrationController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doSignUp(request, response);
	}

	protected void doSignUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/user/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRegister(request, response);
	}

	protected void doRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HElloWorld");
		String name = request.getParameter("fullName");

		System.out.println("Hello: " + name);
		String email = request.getParameter("email");

		LocalDateTime now = LocalDateTime.now();

		String phone = request.getParameter("phoneNumber");
		String dob = request.getParameter("DOB");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");

		User user = new User(name, email, phone, dob, address, now, password);
		boolean set = new RegisterDao().registerUser(user);

		if (!password.equals(repassword)) {
			request.setAttribute("errorPassword", "The password is not equal to repassword!");
			request.getRequestDispatcher("/view/user/signup.jsp").forward(request, response);
		}
		if (set) {
			request.setAttribute("success", "Successfully!");
			request.getRequestDispatcher("/view/user/signup.jsp").forward(request, response);
		} else {
			request.setAttribute("notSuccess", "Impossible to create new user!");
			request.getRequestDispatcher("/view/user/signup.jsp").forward(request, response);
		}
	}

}

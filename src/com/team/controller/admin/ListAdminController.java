package com.team.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.AdminDaoImpl;
import com.team.model.Admin;

/**
 * Servlet implementation class ListAdminController
 */

public class ListAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doListAdim(request, response);
	}

	protected void doListAdim(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Admin> listAdmin = new AdminDaoImpl().getAll();
		System.out.println(listAdmin.toString() + "size:" + listAdmin.size());
		request.setAttribute("adminList", listAdmin);
		request.getRequestDispatcher("/view/admin/admin.jsp").forward(request, response);
	}

}

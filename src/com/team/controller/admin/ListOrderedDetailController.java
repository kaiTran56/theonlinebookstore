package com.team.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.OrderedDaoImpl;
import com.team.model.Ordered;

/**
 * Servlet implementation class ListOrderedDetailController
 */

public class ListOrderedDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListOrderedDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Ordered> listOrdered = new OrderedDaoImpl().getProduct(id);
		request.setAttribute("orderedlist", listOrdered);
		request.getRequestDispatcher("/view/admin/show-orderdetail.jsp").forward(request, response);
	}

}

package com.team.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.TransactionDaoImpl;
import com.team.model.Category;
import com.team.model.Transactions;

/**
 * Servlet implementation class ListOrderController
 */

public class ListOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doListOrder(request, response);
	}

	protected void doListOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Transactions> listOrder = new TransactionDaoImpl().getAll();
		request.setAttribute("order", listOrder);
		request.getRequestDispatcher("/view/admin/show-order.jsp").forward(request, response);
	}

}

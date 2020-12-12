package com.team.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.OrderedDaoImpl;
import com.team.dao.impl.TransactionDaoImpl;
import com.team.dao.impl.UserDaoImpl;
import com.team.model.Item;
import com.team.model.Order;
import com.team.model.Ordered;
import com.team.model.Transactions;
import com.team.model.User;

/**
 * Servlet implementation class PlaceOrderController
 */

public class PlaceOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int maxOrds_id;
	private int maxTrans_id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPlaceOrder(request, response);
	}

	protected void doPlaceOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");

		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("username");
		User user = new UserDaoImpl().get(email);

		String status = "Not Finish!";

		Order order = (Order) session.getAttribute("order");

		List<Item> listItems = order.getItems();

		LocalDateTime created = LocalDateTime.now();
		double payment = order.getSumPrice();
		maxTrans_id = (Integer) session.getAttribute("maxTransaction_id");
		maxTrans_id++;
		Transactions transaction = new Transactions(maxTrans_id, user, message, payment, status, created);
		new TransactionDaoImpl().insert(transaction);

		maxOrds_id = (Integer) session.getAttribute("maxOrdered_id");

		listItems.forEach(p -> {
			maxOrds_id++;
			Ordered orderTemp = new Ordered(maxOrds_id, p.getProduct().getProduct_id(), maxTrans_id, p.getAmount());
			new OrderedDaoImpl().insert(orderTemp);
		});

		System.out.println("Max: " + maxTrans_id);

		session.removeAttribute("order");
		System.out.println("Successfully!");

		response.sendRedirect(request.getContextPath() + "/view/user/checkout");
	}

}

package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.model.Item;
import com.team.model.Order;

/**
 * Servlet implementation class UpdateCartController
 */

public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goCheckOut(request, response);
	}

	protected void goCheckOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/user/template/check-out.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doUpdateCart(request, response);
	}

	protected void doUpdateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		order.setSumPrice(0);
		listItems.forEach(p -> {
			p.setAmount(p.getProduct().getProduct_id());
			p.setPrice(p.getProduct().getPrice());
			order.setSumPrice(order.getSumPrice() + p.getPrice());
		});
		System.out.println("Hello!");
		System.out.println("Update cart!");
		order.setItems(listItems);
		session.setAttribute("order", order);
		session.setAttribute("sumprice", order.getSumPrice());
		response.sendRedirect(request.getContextPath() + "/view/user/checkout");
	}

}

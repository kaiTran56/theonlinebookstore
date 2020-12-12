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
 * Servlet implementation class UpdateQuantityProductController
 */

public class UpdateQuantityProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String check_id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateQuantityProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doUpdateQuantity(request, response);
	}

	protected void doUpdateQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello");
		check_id = request.getParameter("check_id");
		System.out.println("Check_id: " + check_id);
		int product_id = Integer.parseInt(check_id);
		int checkQuantity = Integer.parseInt(request.getParameter("purchase-quantity"));

		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		order.setSumPrice(0);
		listItems.stream().filter(p -> p.getProduct().getProduct_id() == product_id).forEach(p -> {
			p.setAmount(checkQuantity);

			p.setPrice(p.getProduct().getPrice() * checkQuantity);

			System.out.println("Check Quantity and Price: " + p.getAmount() + " : " + p.getPrice());

			order.setSumPrice(order.getSumPrice() + p.getPrice());
		});
		System.out.println("Quantity: " + checkQuantity);
		order.setItems(listItems);
		session.setAttribute("order", order);
		session.setAttribute("sumprice", order.getSumPrice());
		System.out.println("Successfully to update quantity");

		response.sendRedirect(request.getContextPath() + "/view/user/shop");
	}

}

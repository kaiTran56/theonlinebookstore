package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Item;
import com.team.model.Order;
import com.team.model.Product;

/**
 * Servlet implementation class DeleteProductIntCartController
 */
@WebServlet("/DeleteProductIntCartController")
public class DeleteProductInCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProductInCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDeleteProductInCart(request, response);
	}

	protected void doDeleteProductInCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		Product product = new ProductDaoImpl().get(Integer.parseInt(id));
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();

		Item itemTemp = listItems.stream().filter(p -> p.getId().equals(product.getProduct_id() + "")).findFirst()
				.orElse(null);

		order.setSumPrice(order.getSumPrice() - itemTemp.getPrice());

		listItems.remove(itemTemp);

		System.out.println("Successfully to delete product from cart!" + " Price: " + order.getSumPrice());

		int sizeTemp = listItems.size();
		session.setAttribute("length", sizeTemp);

		order.setItems(listItems);
		session.setAttribute("order", order);

		response.sendRedirect(request.getContextPath() + "/view/user/shopping-cart");

		if (order.getSumPrice() == 0) {
			session.setAttribute("sumprice", "0");
		} else {
			session.setAttribute("sumprice", order.getSumPrice());
		}
	}

}

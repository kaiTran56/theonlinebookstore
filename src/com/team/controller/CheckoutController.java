package com.team.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.OrderedDaoImpl;
import com.team.dao.impl.ProductDaoImpl;
import com.team.dao.impl.TransactionDaoImpl;
import com.team.dao.impl.UserDaoImpl;
import com.team.model.Category;
import com.team.model.Item;
import com.team.model.Order;
import com.team.model.Ordered;
import com.team.model.Product;
import com.team.model.Transactions;
import com.team.model.User;

/**
 * Servlet implementation class CheckoutController
 */

public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDaoImpl productDao;
	private int transaction_id;
	private int ordered_id;

	private Ordered orderTemp;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutController() {
		super();
		this.productDao = new ProductDaoImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goCheckout(request, response);

	}

	protected void goCheckout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = new CategoryDaoImpl().getAll();

		request.setAttribute("listcategory", listCategory);
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("username");
		if (email != null) {
			User user = new UserDaoImpl().get(email);
			request.setAttribute("createdDay", user.getCreated());
			request.setAttribute("userDetail", user);
			request.getRequestDispatcher("/view/user/template/check-out.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("/view/user/template/check-out.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doCheckout(request, response);
	}

	protected void doCheckout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello!");
		String message = request.getParameter("message");

		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("username");
		User user = new UserDaoImpl().get(email);

		String status = "Waiting...!";

		Order order = (Order) session.getAttribute("order");

		List<Item> listItems = order.getItems();

		LocalDateTime created = LocalDateTime.now();
		double payment = order.getSumPrice();

		Transactions transaction = new Transactions(user, message, payment, status, created);
		new TransactionDaoImpl().insert(transaction);

		transaction_id = new TransactionDaoImpl().getTheLastest().getTransaction_id();

		ordered_id = new OrderedDaoImpl().getMaxId().getOrdered_id();

		for (Item p : listItems) {
			ordered_id++;
			orderTemp = new Ordered(ordered_id, p.getProduct().getProduct_id(), transaction_id, p.getAmount());

			int purchaseQuantity = p.getAmount();
			int previousQuantity = p.getProduct().getQuantity();
			int newQuantity = previousQuantity - purchaseQuantity;

			new OrderedDaoImpl().insert(orderTemp);

			productDao.updateQuantity(new Product(p.getProduct().getProduct_id(), newQuantity));
		}

		// Check out status:
		request.setAttribute("checkTransaction", "Place order successfully!");

		session.removeAttribute("order");

		response.sendRedirect(request.getContextPath() + "/view/user/checkout");

	}

}

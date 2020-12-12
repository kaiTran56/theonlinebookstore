package com.team.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Product;

/**
 * Servlet implementation class ViewByPriceController
 */

public class ViewByPriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewByPriceController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double priceStart = Double.parseDouble(request.getParameter("price-start"));
		System.out.println("Check Price-Start: " + priceStart);
		double priceEnd = Double.parseDouble(request.getParameter("price-end"));
		System.out.println("Check Price-End: " + priceEnd);

		List<Product> listPrice = new ProductDaoImpl().getAll().stream()
				.filter(p -> p.getPrice() >= priceStart && p.getPrice() <= priceEnd).collect(Collectors.toList());
		request.setAttribute("listproduct", listPrice);
		request.getRequestDispatcher("/view/user/template/shop.jsp").forward(request, response);
	}

}

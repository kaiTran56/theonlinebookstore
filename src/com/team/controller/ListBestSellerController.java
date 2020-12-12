package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.OrderedDaoImpl;
import com.team.model.Category;
import com.team.model.Ordered;

public class ListBestSellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBestSellerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showBestSeller(request, response);
	}

	protected void showBestSeller(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = new CategoryDaoImpl().getAll();

		request.setAttribute("listcategory", listCategory);

		List<Ordered> listBestSeller = new OrderedDaoImpl().getBestSeller();
		System.out.println("Show best seller: " + listBestSeller.toString());
		request.setAttribute("listproduct", listBestSeller);

		request.getRequestDispatcher("/view/user/template/best-sellers.jsp").forward(request, response);

	}

}

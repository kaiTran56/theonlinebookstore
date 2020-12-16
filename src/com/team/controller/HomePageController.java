package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.BoardnewDaoImpl;
import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Boardnew;
import com.team.model.Category;
import com.team.model.Product;

/**
 * Servlet implementation class HomePageController
 */

public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Boardnew> listBoardnew = new BoardnewDaoImpl().getAll();
		request.setAttribute("boardnewlist", listBoardnew);

		List<Category> listCategory = new CategoryDaoImpl().getAll();
		request.setAttribute("listcategory", listCategory);

		List<Product> listPorduct = new ProductDaoImpl().getAll();

		request.setAttribute("listproduct", listPorduct);

		request.getRequestDispatcher("/view/user/template/index.jsp").forward(request, response);
		//goHome(request, response);

	}

	protected void goHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

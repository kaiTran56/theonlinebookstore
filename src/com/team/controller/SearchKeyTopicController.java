package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.CategoryDaoImpl;
import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Category;
import com.team.model.Product;

/**
 * Servlet implementation class SearchKeyTopicController
 */

public class SearchKeyTopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchKeyTopicController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = new CategoryDaoImpl().getAll();

		request.setAttribute("listcategory", listCategory);
		String keyword = request.getParameter("search-key");
		String topic = request.getParameter("option-topic");

		if (topic.equals("default")) {
			List<Product> listProductByKey = new ProductDaoImpl().getProductByKey(keyword);

			request.setAttribute("listproductkey", listProductByKey);
			request.getRequestDispatcher("/view/user/template/search-result.jsp").forward(request, response);
		} else {
			List<Product> listProductKeyTopic = new ProductDaoImpl().searchByKeyTopic(keyword, topic);
			if (listProductKeyTopic.size() == 0) {
				request.setAttribute("no-result", "Nothing to show!");
			}
			request.setAttribute("listproductkey", listProductKeyTopic);
			request.getRequestDispatcher("/view/user/template/search-result.jsp").forward(request, response);
		}

	}

}

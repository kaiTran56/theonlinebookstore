package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.BoardnewDaoImpl;
import com.team.dao.impl.CategoryDaoImpl;
import com.team.model.Boardnew;
import com.team.model.Category;

/**
 * Servlet implementation class BoardnewDetailController
 */

public class BoardnewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardnewDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response) ${pageContext.request.contextPath}/view/user/new/detail
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showBoardnewDetail(request, response);

	}

	protected void showBoardnewDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = new CategoryDaoImpl().getAll();
		request.setAttribute("listcategory", listCategory);

		int boardnewId = Integer.parseInt(request.getParameter("id"));

		Boardnew boardnewTemp = new BoardnewDaoImpl().get(boardnewId);
		System.out.println(boardnewTemp.toString());
		request.setAttribute("newsdaily", boardnewTemp);
		request.getRequestDispatcher("/view/user/template/blog-details.jsp").forward(request, response);
	}

}

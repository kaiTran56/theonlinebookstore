package com.team.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.BoardnewDaoImpl;
import com.team.model.Boardnew;

/**
 * Servlet implementation class BoardnewDetailListController
 */
@WebServlet("/BoardnewDetailListController")
public class BoardnewDetailListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardnewDetailListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Boardnew boardnew = new BoardnewDaoImpl().get(id);
		request.setAttribute("boardnewTemp", boardnew);
		
		List<Boardnew> boardnewList = new BoardnewDaoImpl().getAll();
		request.setAttribute("boardnewlist", boardnewList);
		
		request.getRequestDispatcher("").forward(request, response);
	}
	protected void showBoardnewList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

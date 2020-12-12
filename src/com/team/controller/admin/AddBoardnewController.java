package com.team.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team.model.Boardnew;

public class AddBoardnewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBoardnewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		goAddBoardnew(request, response);
	}

	protected void goAddBoardnew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/admin/addboardnew.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAddBoardnew(request, response);
	}

	protected void doAddBoardnew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String title = request.getParameter("new-title");
		String content = request.getParameter("new-content");
		String author = request.getParameter("new-author");
		LocalDateTime created = LocalDateTime.now();
		System.out.println("Check: " + title + content + author);
		Boardnew boardnew = new Boardnew(title, content, author, created);
		session.setAttribute("boardnewTemp", boardnew);
		response.sendRedirect(request.getContextPath() + "/view/admin/imageupload.jsp");
	}

}

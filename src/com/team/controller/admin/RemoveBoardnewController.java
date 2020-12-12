package com.team.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.dao.impl.BoardnewDaoImpl;

/**
 * Servlet implementation class RemoveBoardnewController
 */

public class RemoveBoardnewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBoardnewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTemp = Integer.parseInt(request.getParameter("boardnew-id"));
		new BoardnewDaoImpl().delete(idTemp);
		response.sendRedirect(request.getContextPath()+"/admin/list-boardnew");
	}

}

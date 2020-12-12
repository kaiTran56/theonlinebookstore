package com.team.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.team.dao.impl.BoardnewDaoImpl;
import com.team.model.Boardnew;

/**
 * Servlet implementation class ImageUpload
 */

public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uploadImageBoardnew(request, response);
	}

	protected void uploadImageBoardnew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("HEllow!");
		/*
		 * if (!ServletFileUpload.isMultipartContent(request)) {
		 * out.println("Nothing to upload"); return; }
		 */
		FileItemFactory itemfactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemfactory);

		try {
			List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem item : items) {
				String contentType = item.getContentType();
				System.out.println("Type: " + contentType);

				/*
				 * @use: check type of file to upload to server
				 * 
				 * @result: Server just recieve the image which have types: png or jpeg
				 * 
				 */

				if (!contentType.equals("image/jpeg") && !contentType.equals("image/png")) {

					continue;
				}

				String fileUrl = "C:\\Users\\ASUS\\eclipse-workspacejee\\theonlinebook\\WebContent\\images";
				File uploadDir = new File(fileUrl);
				System.out.println("address: " + uploadDir.getAbsolutePath());
				File file = File.createTempFile("img", ".png", uploadDir);
				item.write(file);
				url = file.getAbsolutePath();
				Boardnew boardnew = (Boardnew) session.getAttribute("boardnewTemp");
				boardnew.setImage_link(url);
				System.out.println("Hello: " + boardnew.getAuthor() + "  " + boardnew.getImage_link());

				System.out.println(url);
				new BoardnewDaoImpl().insert(boardnew);
				session.removeAttribute("boardnewTemp");
				response.sendRedirect(request.getContextPath() + "/admin/list-boardnew");

			}
		} catch (FileUploadException e) {

		} catch (Exception ex) {

		}
	}

}

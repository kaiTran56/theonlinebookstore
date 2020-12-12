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

import com.team.dao.impl.ProductDaoImpl;
import com.team.model.Product;

/**
 * Servlet implementation class ImageProductController
 */

public class ImageProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uploadImageProduct(request, response);
	}

	protected void uploadImageProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url;
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

				String fileUrl = "C:\\Users\\Admin\\eclipse-workspace\\TheOnlineBook\\WebContent\\images";
				File uploadDir = new File(fileUrl);
				System.out.println("address: " + uploadDir.getAbsolutePath());
				File file = File.createTempFile("img", ".png", uploadDir);
				item.write(file);
				url = file.getAbsolutePath();
				Product product = (Product) session.getAttribute("productTemp");
				System.out.println((Integer) session.getAttribute("idproduct"));
				product.setProduct_id((Integer) session.getAttribute("idproduct"));
				product.setImage_link(url);

				new ProductDaoImpl().insert(product);

				session.removeAttribute("productTemp");

				response.sendRedirect(request.getContextPath() + "/admin/list-product");

			}
		} catch (FileUploadException e) {

		} catch (Exception ex) {

		}
	}

}

package com.jsp.Servlet.School.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Servlet.School.Controller.Controller;

@WebServlet(value = "/Delete")
public class Delete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("name");																			
		
		
		Controller controller = new Controller();
		PrintWriter printWriter = resp.getWriter();
		
		if (controller.delete_student(id)) {
			printWriter.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Register-login</title>\r\n"
					+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">    \r\n"
					+ "        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\">\r\n"
					+ "    \r\n"
					+ "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n"
					+ "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
					+ "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\r\n"
					+ "        \r\n"
					+ "\r\n"
					+ "    </head>\r\n"
					+ "    <body>\r\n"
					+ "        <div class=\"container\">\r\n"
					+ "          <div class=\"row\">\r\n"
					+ "            <div class=\"col-12\">\r\n"
					+ "              <div class=\"d-flex justify-content-center\">\r\n"
					+ "                <div class=\"text-center bg-warning py-4 px-5 h2 font-weight-normal border border-info rounded my-5\">\r\n"
					+ "                  Student Data Deleted\r\n"
					+ "                </div>\r\n"
					+ "              </div>\r\n"
					+ "            </div>\r\n"
					+ "          </div>\r\n"
					+ "        </div>\r\n"
					+ "    </body>\r\n"
					+ "</html>");
		} else {
			resp.sendRedirect("Failed.html");
		}
	}
}

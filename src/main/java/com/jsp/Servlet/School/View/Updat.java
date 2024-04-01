package com.jsp.Servlet.School.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Servlet.School.Controller.Controller;

@WebServlet(value = "/Updat")
public class Updat extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String password = req.getParameter("pass");
		String mail = req.getParameter("mail");
		String contact = req.getParameter("contact");
		String add = req.getParameter("add");
		String username = req.getParameter("user");
		
		Controller controller = new Controller();
		PrintWriter printWriter = resp.getWriter();
		
		if (controller.update_student(id,name,age,mail,contact,add,username,password)) {
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
					+ "                  Student Data Updated\r\n"
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

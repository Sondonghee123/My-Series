package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;

import PersonalProject.MsrService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/main.go")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MsrService service = new MsrService();
		request.setAttribute("all", service.selectAll());
		request.getRequestDispatcher("MySeriesWeb/html/main.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

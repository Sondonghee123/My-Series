package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PersonalProject.MsrDTO;
import PersonalProject.MsrService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete.go")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("card_title");
		
		MsrService service = new MsrService();
		service.msrDelete(title);
		request.setAttribute("list", service.selectAll());
		request.getRequestDispatcher("MySeriesWeb/html/delete.jsp").forward(request, response);
	}

}

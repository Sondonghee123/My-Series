package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PersonalProject.MsrDTO;
import PersonalProject.MsrService;
import PersonalProject.UserDTO;

/**
 * Servlet implementation class TitleSelectServlet
 */
@WebServlet("/tselect.go")
public class TitleSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("titleselect");
		
		MsrService service = new MsrService();
		List<MsrDTO> result = service.selectByname(title);
		request.setAttribute("list", result);
		request.getRequestDispatcher("MySeriesWeb/html/searchTitle.jsp").forward(request, response);
	
	}

}

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
 * Servlet implementation class ScoreSelectServlet
 */
@WebServlet("/scoreselect.go")
public class ScoreSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String score = request.getParameter("scoreselect");
		
		MsrService service = new MsrService();
		List<MsrDTO> result = service.selectByscore(score);
		request.setAttribute("list", result);
		request.getRequestDispatcher("MySeriesWeb/html/searchScore.jsp").forward(request, response);
	}

}

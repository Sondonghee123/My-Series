package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PersonalProject.MsrService;

/**
 * Servlet implementation class PostingServlet
 */
@WebServlet("/post.go")
public class PostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String star = request.getParameter("star");
		String comment = request.getParameter("comment");
		String type = request.getParameter("type");
		String genre = request.getParameter("genre");
		String producer = request.getParameter("producer");
		
		System.out.println(image + title + star + comment + type + genre + producer);
	}

}

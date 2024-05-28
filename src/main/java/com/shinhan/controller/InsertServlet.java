package com.shinhan.controller;

import java.io.IOException;
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
@WebServlet("/insert.go")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String star = request.getParameter("star");
		String comment = request.getParameter("comment");
		String type = request.getParameter("type");
		
		MsrDTO msr = new MsrDTO();
		msr.setImages(image);
		msr.setTypes(type);
		msr.setName(title);
		msr.setScore(star);
		msr.setComments(comment);
		
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("loginUser");
		msr.setUser_id(user.getUser_id());
		msr.setUser_pw(user.getUser_pw());
		System.out.println(msr);
		 
		MsrService service = new MsrService();
		int result = service.msrInsert(msr);
	    response.getWriter().append(result + "");
	
	}

}

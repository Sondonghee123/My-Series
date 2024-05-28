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
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify.go")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String image = request.getParameter("image_m");
		String title = request.getParameter("title_m");
		String star = request.getParameter("star_m");
		String comment = request.getParameter("comment_m");
		String type = request.getParameter("type_m");
		String originalName = request.getParameter("originalName");
		
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
		
		int result = service.msrUpdate(msr, originalName);
	    response.getWriter().append(result + "");
	}


}

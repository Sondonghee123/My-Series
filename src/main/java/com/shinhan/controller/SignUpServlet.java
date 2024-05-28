package com.shinhan.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PersonalProject.MsrService;
import PersonalProject.MsrView;
import PersonalProject.UserDTO;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup.go")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MsrService msrService = new MsrService();
		UserDTO user = new UserDTO();
	    user.setUser_id(id);
	    user.setUser_pw(pw);
		int result = msrService.IDinsert(user);
		response.getWriter().append(result + "");

		System.out.println(id + pw);
	}
}

package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ant.jmx.JMXAccessorQueryTask;
import org.apache.catalina.connector.Response;

import PersonalProject.MsrService;
import PersonalProject.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("MySeriesWeb/html/login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("logId");
		String pw = request.getParameter("logPw");
		UserDTO user = new UserDTO(id, pw);
		System.out.println(user);
		MsrService service = new MsrService();
		int result = service.signUp(user);
		System.out.println(result);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("main.go");
		} else {
			response.getWriter().append("<script> alert('아이디 또는 비밀번호를 확인하세요.'); location.href = 'login.do';</script>");
		}
		
	}

}

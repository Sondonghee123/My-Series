package com.shinhan.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.shinhan.emp.EmpDTO;

import PersonalProject.MsrDTO;
import PersonalProject.UserDTO;
/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("*.go")
public class LoginCheckFilter extends HttpFilter implements Filter {
       
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //로그인하지 않으면 업무로직 수행 못함
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        
        if(!req.getRequestURI().endsWith("signup.go")) {
        	session.setAttribute("lastRequest", req.getRequestURI());
        	
            UserDTO user = (UserDTO) session.getAttribute("loginUser");
            if(user == null) {
                // 로그인되어있지않으면 브라우저로 내려가서 로그인으로 재요청
                res.sendRedirect("../webproject/login.do");
                return;
            }
        }
        chain.doFilter(request, response);
    }
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
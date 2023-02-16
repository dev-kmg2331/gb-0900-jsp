package com.example.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Join extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Join() {;}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		req.getSession().setAttribute("userId", 1L);
		
		req.setAttribute("name", "강민구");
		req.setAttribute("age", 21);
		req.getRequestDispatcher("jstl-test02.jsp").forward(req, resp);
//		out.print("<a href='jstl-test01.jsp?name=강민구&age=20'>이름 전송</a>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

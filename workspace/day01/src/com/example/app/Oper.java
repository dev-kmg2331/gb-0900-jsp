package com.example.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Oper() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Calc calc = new Calc();
		String result = "";
		
		try {
			result = String.valueOf(calc.caculate(request.getParameter("equation")));
			out.print("<div style='text-align : center'>계산식은 : " + request.getParameter("equation") + "입니다.</div>");
		} catch (ArithmeticException e) {
			result = "0으로 나눌 수 없음";
		} catch (IndexOutOfBoundsException e) {
			result = "빈 수식입니다";
		} catch (Exception e) {
			result = "올바른 연산식이 아닙니다";
		}
		 
		
		out.print("<div style='text-align : center'>결과값은 : " + result + " 입니다.</div>");
		out.print("<a href='calc'>다시 쓰기</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

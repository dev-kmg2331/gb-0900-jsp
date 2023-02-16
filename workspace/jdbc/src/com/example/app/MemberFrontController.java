package com.example.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.domain.MemberVO;
import com.example.app.member.MemberJoinActionController;

public class MemberFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public MemberFrontController() {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		
		String uri = req.getRequestURI();
		String target = uri.replaceAll(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;
		
		if(target.equals("join")) {
			result = new Result();
			result.setPath(req.getContextPath() + "/join.member");
			result.setRedirect(true);
		}else if(target.equals("joinAction")) {
			result = new MemberJoinActionController().excute(req, resp);
		}else if(target.equals("check")) {
			result = new MemberJoinActionController().excute(req, resp);
		}else if(target.equals("login")) {
			
		}else if(target.equals("loginAction")) {
			
		} else {
//			404페이지 제작하여 이동
			System.out.println("몰?루");
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			} else {
				
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package com.example.app.member;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Result;
import com.example.app.dao.MemberDAO;
import com.example.app.domain.MemberVO;

public class MemberJoinActionController {
	public Result excute(HttpServletRequest req, HttpServletResponse resp) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		Result result = new Result();
		
		String encodedPw = new String(Base64.getEncoder().encode(req.getParameter("memberPassword").getBytes()));
		
		vo.setMemberIdentification(req.getParameter("memberIdentification"));
		vo.setMemberPassword(encodedPw);
		
		dao.join(vo);
		
		result.setPath(req.getContextPath() + "/login.jsp");
		result.setRedirect(true);
		
		return result;
	}
}

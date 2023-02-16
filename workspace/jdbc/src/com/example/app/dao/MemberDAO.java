package com.example.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.app.domain.MemberVO;

public class MemberDAO {
	Connection con;
	PreparedStatement pr;
	ResultSet rs;
	
//	아이디 중복검사
	public boolean checkId() {return false;}
	
//	회원가입
	public void join(MemberVO memberVO) {
		String query = "INSERT INTO TBL_MEMBER "
				+ "(MEMBER_ID, MEMBER_IDENTIFICATION, MEMBER_PASSWORD) "
				+ "VALUES(SEQ_MEMBER.NEXTVAL, ?, ?)";
		
		con = DBConnecter.getConnection();
		try {
			pr = con.prepareStatement(query);
			pr.setString(1, memberVO.getMemberIdentification());
			pr.setString(2, memberVO.getMemberPassword());
			pr.execute(	);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				
				if(pr != null) {
					pr.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	로그인
	public Long login() {return null;}
}

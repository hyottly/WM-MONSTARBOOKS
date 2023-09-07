package com.monstar.books.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.monstar.books.member.dao.MemberDao;
import com.monstar.books.member.dto.MemberDto;

@Service
public class AdMemberDeleteService implements MemberService {
	@Autowired
	private SqlSession sqlSession;

	public AdMemberDeleteService() {}

	public AdMemberDeleteService(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public void execute(Model model) {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		// asMap = 인덱스 번호도 같이 가져올수있다.
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int memberno = Integer.parseInt(request.getParameter("memberNo"));
		
		dao.delete(memberno);
		
		System.out.println(memberno);

	}// method override

}// class
package kr.bit.model;

import java.io.IOException;
import java.io.InputStream;
// JDBC->myBatis, JPA
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.log.LogFactory;

@Repository
public class MemberDAO {
	
	@Autowired
	private  SqlSessionFactory sessionFactory;
	
	// 회원전체 리스트보기
	public List<MemberVO> memberList() {
		// SqlSession 생성
		SqlSession session = sessionFactory.openSession();
		// mapper와 연결
		List<MemberVO> list = session.selectList("memberList");
		session.close();

		return list;
	}

	// 회원 가입
	public int memberInsert(MemberVO memberVO) {
		SqlSession session = sessionFactory.openSession();
		int cnt = session.insert("memberInsert", memberVO);
		session.commit();
		session.close();

		return cnt;
	}

	
   // 회원가입(파일 있는경우)
   public int memberInsertFile(MemberVO vo) {
	   SqlSession session= sessionFactory.openSession();
	   int cnt=session.insert("memberInsertFile", vo);
	   session.commit();
	   session.close();//반납
	   return cnt;
   }
	
	// Delete
	public int memberDelete(int num) {
		SqlSession session = sessionFactory.openSession();
		int result = session.delete("memberDelete",num);
		session.commit();
		session.close();
		
		return result;
	}
	
	//fileDelte 
	public int memberDeleteFile(int num) {
		SqlSession session = sessionFactory.openSession();
		int result = session.update("memberDeleteFile",num);
		session.commit();
		session.close();
		return result;
	}

	//Content
	public MemberVO memberContent(int num) {
		SqlSession session = sessionFactory.openSession();
		MemberVO memberVO = session.selectOne("memberContent",num);
		session.close();
		
		return memberVO;
	}
	
	//Update
	public int memberUpdate (MemberVO vo) {
		SqlSession session = sessionFactory.openSession();
		int cnt = session.update("memberUpdate",vo);
		session.commit();
		session.close();
		
		return cnt;
	}
	
	//LOGIN
	public String memberLogin(MemberVO vo) {
		SqlSession session = sessionFactory.openSession();
		String id = session.selectOne("memberLogin",vo);
		session.close();
		return id;
	}
	
	//중복 체크
	public String dbCheck(String id) {
		SqlSession session = sessionFactory.openSession();
		String dbId = session.selectOne("dbCheck",id);
		String isDouble = "NO";
		
		if(dbId != null) {
			isDouble = "Yes";
		}
		
		session.close();
		return isDouble; //Yes(중복), NO(아님)
	}
	
}

package spms.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import spms.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spms.annotation.*;


@Component("memberDao")
public class MysqlMemberDao implements MemberDao{
	SqlSessionFactory sqlFac;
	
	public void setDataSource(SqlSessionFactory sqlFac){
		this.sqlFac = sqlFac;
	}
	
	public List<Member> selectList(HashMap<String, Object>paramMap) throws Exception{
		SqlSession sqlSession = sqlFac.openSession();
		
		try{
			return sqlSession.selectList("spms.dao.MemberDao.selectList", paramMap);
		}finally{
			sqlSession.close();
		}
	}
	
	public int insert(Member member) throws Exception{
			SqlSession sqlSession = sqlFac.openSession();
		
		try{
			int cnt = sqlSession.insert("spms.dao.MemberDao.insert", member);
			sqlSession.commit();
			return cnt;
		}finally{
			sqlSession.close();
		}
	}
	
	public Member selectOne(int no) throws Exception{
		SqlSession sqlSession = sqlFac.openSession();
		
		try{
			return sqlSession.selectOne("spms.dao.MemberDao.selectOne", no);
		}finally{
			sqlSession.close();
		}
	}
	
	public int update(Member member) throws Exception{
		SqlSession sqlSession = sqlFac.openSession();
		
		try{
			Member origin = sqlSession.selectOne("spms.dao.MemberDao.selectOne", member.getMno());
			Hashtable<String, Object>paramMap = new Hashtable<String, Object>();
			
			if(!member.getEmail().equals(origin.getEmail())) paramMap.put("email", member.getEmail());
			if(!member.getName().equals(origin.getName())) paramMap.put("mname", member.getName());
			
			
			if(paramMap.size() > 0){
				paramMap.put("mno", member.getMno());
				int cnt = sqlSession.update("spms.dao.MemberDao.update", paramMap);
				sqlSession.commit();
				return cnt;
			}else return 0;
		}finally{
			sqlSession.close();
		}
	}
	
	public int delete(int no) throws Exception{
		SqlSession sqlSession = sqlFac.openSession();
		
		try{
			int cnt = sqlSession.delete("spms.dao.MemberDao.delete", no);
			sqlSession.commit();
			return cnt;
		}finally{ 
			sqlSession.close();
		}
	}
	
	public Member exist(String email, String pwd) throws Exception{
		SqlSession sqlSession = sqlFac.openSession();
		Hashtable<String, Object> paramMap = new Hashtable<String, Object>();
		paramMap.put("email", email);
		paramMap.put("pwd", pwd);
		
		try{
			return sqlSession.selectOne("spms.dao.MemberDao.logInfo", paramMap);
		}finally{
			sqlSession.close();
		}
	}
}

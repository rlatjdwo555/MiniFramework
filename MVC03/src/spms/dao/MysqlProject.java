package spms.dao;

import java.util.HashMap;
import java.util.Hashtable;
//import java.sql.*;
import java.util.List;
//import java.util.ArrayList;
//import javax.sql.DataSource;
import spms.vo.Project;
import spms.annotation.*;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component("projectDao")
public class MysqlProject implements ProjectDao {
	SqlSessionFactory sqlSessionFac;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFac){
		this.sqlSessionFac = sqlSessionFac;
	}
	
	public List<Project> selectList(HashMap<String, Object> paramMap) throws Exception{
		SqlSession sqlSession = sqlSessionFac.openSession();
		
		try{ return sqlSession.selectList("spms.dao.ProjectDao.selectList", paramMap); }
		finally{ sqlSession.close(); }
	}
	
	public Project selectOne(int pno) throws Exception{
		SqlSession sqlSession = sqlSessionFac.openSession();
		
		try{ return sqlSession.selectOne("spms.dao.ProjectDao.selectOne", pno); }
		finally{ sqlSession.close(); }
	}
	
	public int insert(Project pjt) throws Exception{
		SqlSession sqlSession = sqlSessionFac.openSession();
		
		try{ 
			int cnt = sqlSession.insert("spms.dao.ProjectDao.insert", pjt); 
			sqlSession.commit();
			return cnt;
		}
		finally{ sqlSession.close(); }
	}
	
	public int update(Project pjt) throws Exception{
		SqlSession sqlSession = sqlSessionFac.openSession();
		
		try{ 
			Project origin = sqlSession.selectOne("spms.dao.ProjectDao.selectOne", pjt.getNo());
			Hashtable<String,Object> paramMap = new Hashtable<String,Object>();
			
	    	if (!pjt.getTitle().equals(origin.getTitle())) paramMap.put("title", pjt.getTitle());
	    	if (!pjt.getContent().equals(origin.getContent())) paramMap.put("content", pjt.getContent());
	    	if (pjt.getStartDate().compareTo(origin.getStartDate()) != 0) paramMap.put("startDate", pjt.getStartDate());
	    	if (pjt.getEndDate().compareTo(origin.getEndDate()) != 0) paramMap.put("endDate", pjt.getEndDate());
	    	if (pjt.getState() != origin.getState()) paramMap.put("state", pjt.getState());
	    	if (!pjt.getTags().equals(origin.getTags())) paramMap.put("tags", pjt.getTags());
	    	
	    	if(paramMap.size() > 0){
	    		paramMap.put("no", pjt.getNo());
	    		int cnt = sqlSession.update("spms.dao.ProjectDao.update", paramMap); 
				sqlSession.commit();
				return cnt;
	    	}
	    	else return 0;
		}
		finally{ sqlSession.close(); }
	}
	
	public int delete(int pno) throws Exception{
		SqlSession sqlSession = sqlSessionFac.openSession();
		
		try{ 
			int cnt = sqlSession.delete("spms.dao.ProjectDao.delete", pno); 
			sqlSession.commit();
			return cnt;
		}
		finally{ sqlSession.close(); }
	}
}

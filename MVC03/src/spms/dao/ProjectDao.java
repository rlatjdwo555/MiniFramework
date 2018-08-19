package spms.dao;

import java.util.List;
import spms.vo.Project;
import java.util.HashMap;

public interface ProjectDao {
	List<Project> selectList(HashMap<String, Object> paramMap) throws Exception;
	Project selectOne(int pno) throws Exception;
	int insert(Project pjt) throws Exception;
	int update(Project pjt) throws Exception;
	int delete(int pno) throws Exception;
}

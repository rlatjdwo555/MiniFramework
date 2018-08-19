package spms.controls;

import java.util.Map;
import spms.bind.DataBinding;
import spms.dao.ProjectDao;
import spms.annotation.*;
import java.util.HashMap;

@Component("/project/list.do")
public class List implements Controller, DataBinding{
	ProjectDao pdao;
	
	public void setDao(ProjectDao pdao){
		this.pdao = pdao;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{
			"orderCond", String.class	
		};
	}
	
	public String excute(Map<String, Object>model) throws Exception{
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderCond", model.get("orderCond"));
		
		model.put("projects", pdao.selectList(paramMap));
		return "/project/ProjectList.jsp";
	}
}

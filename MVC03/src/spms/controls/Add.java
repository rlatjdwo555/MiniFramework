package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.ProjectDao;
import spms.vo.Project;
import spms.bind.DataBinding;

@Component("/project/add.do")
public class Add implements Controller, DataBinding {
	ProjectDao pdao;
	
	public void setDao(ProjectDao pdao){
		this.pdao = pdao;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{"project", spms.vo.Project.class};
	}
	
	public String excute(Map<String, Object> model) throws Exception {
		Project pjt = (Project)model.get("project");
		
		if(pjt.getTitle() != null){
			pdao.insert(pjt);
			return "redirect:list.do";
		}else return "/project/addForm.jsp";
	
		
	}
}


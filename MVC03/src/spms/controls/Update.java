package spms.controls;

import java.util.Map;
import spms.vo.Project;
import spms.dao.ProjectDao;
import spms.bind.DataBinding;
import spms.annotation.*;

@Component("/project/update.do")
public class Update implements Controller, DataBinding{
	ProjectDao pdao;
	
	public void setDao(ProjectDao pdao){
		this.pdao = pdao;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{
				"no", Integer.class,
				"project", spms.vo.Project.class
		};
	}
	
	public String excute(Map<String, Object> model) throws Exception {
		Project pjt = (Project)model.get("project");
		
		if(pjt.getTitle() == null){
			model.put("project", pdao.selectOne((Integer)model.get("no")));
			return "/project/updateForm.jsp";
		}
		else{
			pdao.update(pjt);
			return "redirect:list.do";
		}
		
	}
}

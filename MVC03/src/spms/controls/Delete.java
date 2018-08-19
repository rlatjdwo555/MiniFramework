package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.ProjectDao;

@Component("/project/delete.do")
public class Delete implements Controller, DataBinding {
	ProjectDao pdao;
	
	public void setDao(ProjectDao pdao){
		this.pdao = pdao;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{"no", Integer.class};
	}
	
	public String excute(Map<String, Object> model) throws Exception {
		pdao.delete((Integer)model.get("no"));
		return "redirect:list.do";
	}
}	


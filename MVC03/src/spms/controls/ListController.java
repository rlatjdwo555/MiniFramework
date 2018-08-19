package spms.controls;

import spms.annotation.Component;
import spms.dao.MemberDao;
import java.util.Map;
import java.util.HashMap;
import spms.bind.DataBinding;

@Component("/member/list.do")
public class ListController implements Controller, DataBinding {
	MemberDao mdao;
	
	public void setDao(MemberDao mdao){
		this.mdao = mdao;
	//	return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[]{
				"compInfo", String.class};
	}
	
	
	public String excute(Map<String, Object>model) throws Exception{
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("compInfo", model.get("compInfo"));
		
		model.put("members", mdao.selectList(paramMap));
		return "/member/MemberList.jsp";
	}

}

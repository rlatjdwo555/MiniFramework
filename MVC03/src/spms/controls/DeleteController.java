package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.*;
import spms.dao.*;

@Component("/member/delete.do")
public class DeleteController implements Controller, DataBinding{
	MemberDao mdao;
	
	public DeleteController setMemberDao(MemberDao mdao){
		this.mdao = mdao;
		return this;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{"mno",Integer.class};
	}
	
	
	public String excute(Map<String, Object>model) throws Exception{
		mdao.delete((Integer)model.get("mno"));
		return "redirect:list.do";
	}
}

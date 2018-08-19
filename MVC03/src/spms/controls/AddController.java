package spms.controls;

import java.util.Map;
import spms.annotation.*;
import spms.dao.*;
import spms.vo.*;
import spms.bind.DataBinding;

@Component("/member/add.do")
public class AddController implements Controller, DataBinding{
	MemberDao mdao;
	
	public void setMemberDao(MemberDao mdao){
		this.mdao = mdao;
//		return this;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{"member", spms.vo.Member.class};
	}
	
	public String excute(Map<String, Object>model) throws Exception{
		
		Member member = (Member)model.get("member");
		
		if(member.getEmail() != null){
			mdao.insert(member);
			return "redirect:list.do";
		}else return "/member/addForm.jsp";
	}
}

package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.*;
import spms.dao.*;
import spms.vo.*;

@Component("/member/update.do")
public class UpdateController implements Controller, DataBinding{
	MemberDao mdao;
	
	public UpdateController setMemberDao(MemberDao mdao){
		this.mdao = mdao;
		return this;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{"member", spms.vo.Member.class,
							"mno", Integer.class};
	}
	
	public String excute(Map<String, Object>model) throws Exception{
		
		Member member = (Member)model.get("member");
		
		if(member.getEmail() != null){
			mdao.update(member);
			return "redirect:list.do";
		}else{
			model.put("member", mdao.selectOne((Integer)model.get("mno")));
			return "/member/updateForm.jsp";
		}
	}
}

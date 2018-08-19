package spms.controls;

import javax.servlet.http.*;

import spms.annotation.Component;
import spms.bind.*;
import java.util.Map;
import spms.dao.*;
import spms.vo.*;

@Component("/auth/login.do")
public class LoginController implements Controller, DataBinding {
	MemberDao mdao;
	
	public void setDao(MemberDao mdao){
		this.mdao = mdao;
	//	return this;
	}
	
	public Object[] getDataBinders(){
		return new Object[]{"logInfo", spms.vo.Member.class};
	}
	
	public String excute(Map<String, Object>model) throws Exception{
		
		Member logInfo = (Member)model.get("logInfo");
		
		if(logInfo.getEmail() == null) return "/auth/LoginForm.jsp";
		else{
			Member member = mdao.exist(logInfo.getEmail(), logInfo.getPwd());
			
			if(member != null){
				HttpSession ss = (HttpSession)model.get("ss");
				ss.setAttribute("member", member);
				return "redirect:../member/list.do";
			}else return "/auth/LoginFail.jsp";
		}
	}
}

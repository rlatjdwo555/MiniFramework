package spms.controls;

import javax.servlet.http.*;

import spms.annotation.Component;

import java.util.Map;

@Component("/auth/logout.do")
public class LogoutController implements Controller{
	public String excute(Map<String, Object>model) throws Exception{
		HttpSession ss = (HttpSession)model.get("ss");
		ss.invalidate();
		
		return "redirect:login.do";
	}
}

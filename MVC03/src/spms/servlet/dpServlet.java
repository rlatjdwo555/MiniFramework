package spms.servlet;

import javax.servlet.annotation.*;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import spms.bind.*;
import spms.context.AppContext;
import spms.controls.*;
import spms.listener.LoderListener;
import java.util.HashMap;

@WebServlet("*.do")
public class dpServlet extends HttpServlet {
	
	public void service(HttpServletRequest rq, HttpServletResponse rs) throws IOException, ServletException{
		rs.setContentType("text/html; charset=utf-8");
		String ServletPath = rq.getServletPath();
		
		try{
			HashMap<String, Object>model = new HashMap<String, Object>();
			model.put("ss", rq.getSession());
			
			AppContext ctx = LoderListener.getAppContext();
			Controller pageController = (Controller)ctx.getBean(ServletPath);
			
			if(pageController == null) throw new Exception("Page Not Found");
			
			if(pageController instanceof DataBinding){
				preRequestData(rq, model, (DataBinding)pageController);
			}
			
			String viewUrl = pageController.excute(model);
			
			for(String key : model.keySet()){
				rq.setAttribute(key, model.get(key));
			}
			
			if(viewUrl.startsWith("redirect:")){
				rs.sendRedirect(viewUrl.substring(9));
				return;
			}
			else{
				RequestDispatcher dp = rq.getRequestDispatcher(viewUrl);
				dp.include(rq, rs);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("error", e);
			RequestDispatcher dp = rq.getRequestDispatcher("/Error.jsp");
			dp.forward(rq, rs);
		}
	}
	
	public void preRequestData(HttpServletRequest rq, HashMap<String, Object> model, DataBinding dataBinding )
			throws Exception{
				
				Object[] dataBinders = dataBinding.getDataBinders();
				
				String dataName = null;
				Class<?>dataType = null;
				Object dataObj = null;
				
				for(int i=0 ; i<dataBinders.length; i+=2){
					dataName = (String)dataBinders[i];
					dataType = (Class<?>)dataBinders[i+1];
					dataObj = ServletRequestDataBinder.bind(rq, dataType, dataName);
					model.put(dataName, dataObj);
				}
			}	
}

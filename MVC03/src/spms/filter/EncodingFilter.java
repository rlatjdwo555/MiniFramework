package spms.filter;

import javax.servlet.annotation.*;
import javax.servlet.*;
import java.io.*;

@WebFilter(
		urlPatterns="/*",
		initParams={
			@WebInitParam(name="encoding", value="utf-8")
		})

public class EncodingFilter implements Filter {
	FilterConfig fcon;
	
	public void init(FilterConfig fcon){
		this.fcon = fcon;
	}
	
	public void destroy(){}
	
	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain ch)
	throws IOException, ServletException{
		rq.setCharacterEncoding(fcon.getInitParameter("encoding"));
		ch.doFilter(rq, rp);
	}
	
}

package spms.listener;

import javax.servlet.annotation.*;
import javax.servlet.*;
import spms.context.*;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebListener
public class LoderListener implements ServletContextListener{
	static AppContext appcontext;
	
	public static AppContext getAppContext(){
		return appcontext;
	}
	
	public void contextDestroyed(ServletContextEvent ev) {
	}

	public void contextInitialized(ServletContextEvent ev) {
		try{
			appcontext = new AppContext();
			
			String resour = "spms/dao/mybatis-config.xml";
			InputStream inst = Resources.getResourceAsStream(resour);
			SqlSessionFactory sqlSessionFac = new SqlSessionFactoryBuilder().build(inst);
			
			appcontext.addBean("SqlSessionFactory", sqlSessionFac);
			
			ServletContext sc = ev.getServletContext();
			String propertiesPath = sc.getRealPath(sc.getInitParameter("ctxLocation"));
			
			appcontext.prepareObjects(propertiesPath);  // ������Ƽ ���� ��ü ����
			appcontext.preAno("");			// �ֳ����̼� ��ü ����
			appcontext.injectDependency();  // ������ü ����
			
		}catch(Throwable e){e.printStackTrace();};
	}
}

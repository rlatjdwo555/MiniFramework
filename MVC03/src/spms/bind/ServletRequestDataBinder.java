package spms.bind;

import java.lang.reflect.*;
import java.util.Date;
import java.util.Set;  // Set<String>

import javax.servlet.*;

public class ServletRequestDataBinder {
	public static Object bind(ServletRequest rq, Class<?> dataType, String dataName) throws Exception{
		if(isPrime(dataType)){
			return createObj(dataType, rq.getParameter(dataName));
		}
		
		Set<String> paraNames = rq.getParameterMap().keySet();
		Object DataObj = dataType.newInstance();
		Method m = null;
		
		for(String paraName : paraNames){
			m = findSetter(dataType, paraName);

			if(m != null)
				m.invoke(DataObj, createObj(m.getParameterTypes()[0], rq.getParameter(paraName)));
		}
		return DataObj;
	}
	
	private static boolean isPrime(Class<?> type){
		if(type.getName().equals("int") || type==Integer.class ||
     	 type.getName().equals("long") || type == Long.class ||
	     type.getName().equals("float") || type == Float.class ||
		 type.getName().equals("double") || type == Double.class ||
		 type.getName().equals("boolean") || type == Boolean.class ||
		 type == Date.class || type == String.class) {
		 return true;
		}
		 return false;
	}
	
	private static Object createObj(Class<?> type, String value){
		if(type.getName().equals("int") || type == Integer.class) return new Integer(value);
		else if (type.getName().equals("float") || type == Float.class) return new Float(value);
	    else if (type.getName().equals("double") || type == Double.class) return new Double(value);
	    else if (type.getName().equals("long") || type == Long.class) return new Long(value);
	    else if (type.getName().equals("boolean") || type == Boolean.class) return new Boolean(value);
	    else if (type == Date.class) return java.sql.Date.valueOf(value);
	    else return value;
	}
	
	private static Method findSetter(Class<?>type, String name){
		Method[] methods = type.getMethods();
		String paraName = null;
		
		for(Method m : methods){
			if(!m.getName().startsWith("set")) continue;
			
			paraName = m.getName().substring(3);
			if(paraName.toLowerCase().equals(name.toLowerCase()))
				return m;
		}
		return null;
	}
}

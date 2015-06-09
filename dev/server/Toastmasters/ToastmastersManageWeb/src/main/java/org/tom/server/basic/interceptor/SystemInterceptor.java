package org.tom.server.basic.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tom.server.basic.util.CommonConstants;

/**
 * À¹½ØÆ÷
 * @author yellowshuo
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute(CommonConstants.LOGIN_SESSION_ID);
		String webpath = "http://" + request.getHeader("Host") + request.getContextPath() + "/";
		if ((obj == null || "".equals((String)obj)) && !"/tmw/index".equals(request.getServletPath()) && !"/tmw/login".equals(request.getServletPath())) {
			PrintWriter out = response.getWriter();  
            StringBuilder builder = new StringBuilder();  
            builder.append("<script type=\"text/javascript\" charset=\"GBK\">");  
            builder.append("alert(\"Session Timeout, Login Again!\");");  
            builder.append("window.top.location.href=\"");  
            builder.append(webpath);  
            builder.append("tmw/index\";</script>");  
            out.print(builder.toString());  
            out.close();  
            return false; 
		}
		return super.preHandle(request, response, handler);
	}
}

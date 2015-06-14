package org.tom.server.basic.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tom.server.basic.util.SessionConstants;
import org.tom.server.core.menu.domain.MenuInfoVO;

/**
 * À¹½ØÆ÷
 * @author yellowshuo
 */
public class SystemInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object obj = request.getSession().getAttribute(SessionConstants.LOGIN_SESSION_ID);
		String webpath = "http://" + request.getHeader("Host") + request.getContextPath() + "/";
		if (obj == null && !"/tmw/index".equals(request.getServletPath()) && !"/tmw/login".equals(request.getServletPath())) {
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
		
		// right control
		String res = "";
		@SuppressWarnings("unchecked")
		List<MenuInfoVO> menuList = (ArrayList<MenuInfoVO>)request.getSession().getAttribute(SessionConstants.MENU_SESSION_ID);
		
		if (menuList != null && request.getServletPath().contains("menu")) {
			for (MenuInfoVO menu : menuList) {
				if (request.getServletPath().equals(menu.getMenuURL())) {
					res = "true";
					break;
				} else {
					continue;
				}
			}
			if (!"true".equals(res)) {		// no access right, remove session and return to login page.
				removeAllSession(request.getSession());
				PrintWriter out = response.getWriter();  
	            StringBuilder builder = new StringBuilder();  
	            builder.append("<script type=\"text/javascript\" charset=\"GBK\">");  
	            builder.append("alert(\"You don't have rights to asscess this URL!\");");  
	            builder.append("window.top.location.href=\"");  
	            builder.append(webpath);  
	            builder.append("tmw/index\";</script>");  
	            out.print(builder.toString());  
	            out.close();  
				return false;
			}
		} else {
			if (obj != null && request.getServletPath().contains("menu")) {		// only to control the menu url
				removeAllSession(request.getSession());
				PrintWriter out = response.getWriter();  
	            StringBuilder builder = new StringBuilder();  
	            builder.append("<script type=\"text/javascript\" charset=\"GBK\">");  
	            builder.append("alert(\"You don't have any right to asscess this website!\");");  
	            builder.append("window.top.location.href=\"");  
	            builder.append(webpath);  
	            builder.append("tmw/index\";</script>");  
	            out.print(builder.toString());  
	            out.close();  
				return false;
			}
		}
		
		
		return super.preHandle(request, response, handler);
	}
	
	// remove all the session
	private boolean removeAllSession(HttpSession session) throws IllegalArgumentException, IllegalAccessException {
		
		Field[] fields = SessionConstants.class.getDeclaredFields();
		for (Field field : fields) {
			session.removeAttribute((String)field.get(field.getName()));
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		Field[] fields = SessionConstants.class.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName() + " : " + field.get(field.getName()));
		}
	}
}

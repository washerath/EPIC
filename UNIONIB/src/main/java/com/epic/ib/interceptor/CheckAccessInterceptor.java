package com.epic.ib.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Asitha Perera
 * @Date Time : Mar 18, 2016:12:25:50 PM
 * @Class :CheckAccessInterceptor.java
 **/
public class CheckAccessInterceptor implements HandlerInterceptor {
	private final Log logger = LogFactory.getLog(getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean status = false;
		try {
			HandlerMethod method = (HandlerMethod) handler;
			String methodName = method.getMethod().getName();
			logger.info("Called " + methodName);

			HttpSession session = request.getSession(false);
			if (session == null || session.isNew()) {
				logger.info("Session is Null or New");
				RequestDispatcher rd=request.getRequestDispatcher("logout.htm?error=1");
				rd.forward(request, response);
				status = false;
			} else {
				logger.info("Session ID : " + session.getId());
				status = true;
			}
			
		} catch (Exception ex) {

		}
		return status;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}

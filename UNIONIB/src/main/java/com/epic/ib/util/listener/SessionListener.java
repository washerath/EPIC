package com.epic.ib.util.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author : Asitha Perera
 * @Date Time : Mar 20, 2016:8:16:33 AM
 * @Class :SessionListener.java
 **/
public class SessionListener implements HttpSessionListener {
	private static int activeSessionCount = 0;
	private final Log logger = LogFactory.getLog(getClass());

	public void sessionCreated(HttpSessionEvent event) {
		activeSessionCount++;
		// set sessiontimeout from db
		event.getSession().setMaxInactiveInterval(60);
		logger.info("New Session created : session id (" + event.getSession().getId() + ")");
		logger.info("Active session count : " + activeSessionCount);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		activeSessionCount--;
		logger.info("Session desroyed : session id (" + event.getSession().getId() + ")");
	}

}

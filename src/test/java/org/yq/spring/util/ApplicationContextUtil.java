package org.yq.spring.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationContextUtil {
	public static ApplicationContext getApplicationContext(String cfgUrl) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/" + cfgUrl);
		ctx.refresh();
		return ctx;
	}

	public static void close(ApplicationContext ctx) {
		((GenericXmlApplicationContext) ctx).close();
	}
}

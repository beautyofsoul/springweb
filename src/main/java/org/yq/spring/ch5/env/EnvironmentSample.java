package org.yq.spring.ch5.env;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

public class EnvironmentSample {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.refresh();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		Map appMap = new HashMap();
		appMap.put("application.home", "etc/springweb/home");
		propertySources.addLast(new MapPropertySource("SPRINGWEB_MAP", appMap));
		System.out.println("user.home:" + System.getProperty("user.home"));
		System.out.println("JAVA_HOME:" + System.getenv("JAVA_HOME"));
		System.out.println("user.home:" + env.getProperty("user.home"));
		System.out.println("JAVA_HOME:" + env.getProperty("JAVA_HOME"));
		System.out.println("application.home:"
				+ env.getProperty("application.home"));
		ctx.close();

	}
}

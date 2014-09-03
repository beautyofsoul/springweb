package org.yq.spring.ch5.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value="classpath:META-INF/spring/message.properties")
@ComponentScan(basePackages={"org.yq.spring.ch5.context"})
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	@Lazy(value=true)
	public MessageProvider messageProvider()
	{
		return new ConfigurableMessageProvider(env.getProperty("message"));
	}
	
	@Bean
	@Scope(value="prototype")
	@DependsOn(value="messageProvider")
	public MessageRenderer messageRenderer()
	{
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		return renderer;
	}

}

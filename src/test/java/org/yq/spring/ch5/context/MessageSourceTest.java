package org.yq.spring.ch5.context;

import java.util.Locale;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceTest {

	@Test
	public void testMessageSource() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/messageSource.xml");
		ctx.refresh();
		Locale english = Locale.ENGLISH;
		Locale china = Locale.CHINA;
		System.out.println(ctx.getMessage("msg", null, english));
		System.out.println(ctx.getMessage("msg", null, china));
		System.out.println(ctx.getMessage("nameMsg", new Object[] { "Clarence",
				"Ho" }, english));
		ctx.close();
	}

}

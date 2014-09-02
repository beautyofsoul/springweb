package org.yq.spring.ch5.event;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;

public class PublisherTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/events.xml");
		ctx.refresh();
		Publisher pub = ctx.getBean("publisher", Publisher.class);
		pub.publish("Hello World!");
		pub.publish("Lazy dog!");
		Resource res1 = ctx
				.getResource("file:///D:/Github/springweb/src/test/java/org/yq/spring/ch5/event/PublisherTest.java");
		displayInfo(res1);
		Resource res2 = ctx.getResource("classpath:META-INF/spring/events.xml");
		displayInfo(res2);
		Resource res3 = ctx.getResource("http://www.baidu.com");
		displayInfo(res3);
		ctx.close();
	}

	private void displayInfo(Resource res) {
		System.out.println(res.getClass());
		try {
			System.out.println(res.getURL().getContent());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");

	}

}

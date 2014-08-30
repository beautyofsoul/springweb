package org.yq.spring.ch4.mi;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class ReplacementTargetTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/replacement.xml");
		ctx.refresh();
		ReplacementTarget replaceTarget = (ReplacementTarget) ctx
				.getBean("replacementTarget");
		ReplacementTarget standardTarget = (ReplacementTarget) ctx
				.getBean("standardTarget");
		displayInfo(replaceTarget);
		displayInfo(standardTarget);
		ctx.close();
	}

	private void displayInfo(ReplacementTarget bean) {

		System.out.println(bean.formatMessage("Hello World"));
		StopWatch stopWatch = new StopWatch();

		stopWatch.start("perfTest");

		for (int x = 0; x < 100000; x++) {
			bean.formatMessage("foo");

		}
		stopWatch.stop();

		System.out.println("100000 gets took "
				+ stopWatch.getLastTaskTimeMillis() + " ms");
	}

}

package org.yq.spring.ch4.mi;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class DemoBeanTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/lookup.xml");
		ctx.refresh();
		DemoBean abstractDemo = (DemoBean) ctx.getBean("abstractLookupBean");
		DemoBean standard = (DemoBean) ctx.getBean("standardLookupBean");
		displayInfo(abstractDemo);
		displayInfo(standard);
		ctx.close();
	}

	private void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		System.out
				.println("Helper Instances the same?:" + (helper1 == helper2));
		StopWatch stopWatch = new StopWatch();

		stopWatch.start("lookupDemo");

		for (int x = 0; x < 100000; x++) {
			MyHelper helper = bean.getMyHelper();
			helper.doSomethingHelpful();
		}
		stopWatch.stop();

		System.out.println("100000 gets took "
				+ stopWatch.getLastTaskTimeMillis() + " ms");

	}

}

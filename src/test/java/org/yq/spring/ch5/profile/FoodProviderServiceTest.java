package org.yq.spring.ch5.profile;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodProviderServiceTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles("highschool");
		ctx.load("classpath:META-INF/spring/profile/*-config.xml");
		ctx.refresh();
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService",FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for(Food food:lunchSet)
		{
			System.out.println(food.getName());
		}
		ctx.close();
	}

}

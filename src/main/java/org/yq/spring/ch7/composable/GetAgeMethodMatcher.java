package org.yq.spring.ch7.composable;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcher;

public class GetAgeMethodMatcher extends StaticMethodMatcher {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {

		return "getAge".equals(method.getName());
	}

}

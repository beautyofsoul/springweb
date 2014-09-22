package org.yq.spring.ch6.staticpc;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {

		return "foo".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				return clazz == BeanOne.class;
			}
		};
	}

}

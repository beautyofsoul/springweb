package org.yq.spring.ch7.introductions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor
		implements IsModified {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isModified = false;

	private Map<Method, Method> methodCacha = new HashMap<Method, Method>();

	@Override
	public boolean isModified() {

		return isModified;
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		if (!isModified) {
			if (mi.getMethod().getName().startsWith("set")
					&& mi.getArguments().length == 1) {
				Method getter = getGetter(mi.getMethod());
				if (getter != null) {
					Object newVal = mi.getArguments()[0];
					Object oldVal = getter.invoke(mi.getThis(), null);
					if (newVal == null && oldVal == null) {
						isModified = false;
					} else if (newVal == null && oldVal != null) {
						isModified = true;
					} else if (newVal != null && oldVal == null) {
						isModified = true;
					} else {
						isModified = !newVal.equals(oldVal);
					}
				}
			}
		}
		return super.invoke(mi);
	}

	private Method getGetter(Method setter) {
		Method getter = null;
		getter = (Method) methodCacha.get(setter);
		if (getter != null) {
			return getter;
		}

		String getterName = setter.getName().replaceFirst("set", "get");
		try {
			getter = setter.getDeclaringClass().getMethod(getterName, null);
			synchronized (methodCacha) {

				methodCacha.put(setter, getter);
			}
			return getter;
		} catch (NoSuchMethodException ex) {
			return null;
		}
	}
}

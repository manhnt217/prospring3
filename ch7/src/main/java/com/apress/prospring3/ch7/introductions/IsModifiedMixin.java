package com.apress.prospring3.ch7.introductions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7893417997899129120L;

	private boolean isModified;
	private Map<Method, Method> methodCache = new HashMap<>();

	@Override
	public boolean isModified() {

		return isModified;
	}

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		if (!isModified) {
			//check setter methods only
			if (methodInvocation.getMethod().getName().startsWith("set") && methodInvocation.getArguments().length == 1) {
				Object newVal = methodInvocation.getArguments()[0];
				Method getter = getGetter(methodInvocation);
				Object oldVal = getter.invoke(methodInvocation.getThis());
				if (newVal == null) {
					if (oldVal == null) isModified = false;
					else isModified = true;
				} else {
					isModified = !newVal.equals(oldVal);
				}
			}
		}
		return super.invoke(methodInvocation);
	}

	private Method getGetter(MethodInvocation methodInvocation) {

		Method setter = methodInvocation.getMethod();
		Method getter = methodCache.get(setter);
		if (getter != null) return getter;
		try {
			String getterName = setter.getName().replace("set", "get");
			getter = setter.getDeclaringClass().getMethod(getterName);
			synchronized (methodCache) {
				methodCache.put(setter, getter);
			}
			return getter;
		} catch (NoSuchMethodException | SecurityException e) {
			//write-only property
			return null;
		}
	}

}

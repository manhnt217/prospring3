package com.apress.prospring3.ch7.introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3739693656401769642L;

	public IsModifiedAdvisor() {

		super(new IsModifiedMixin());
	}
}

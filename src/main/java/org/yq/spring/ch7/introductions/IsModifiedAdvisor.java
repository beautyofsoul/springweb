package org.yq.spring.ch7.introductions;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = 1L;

	public IsModifiedAdvisor() {
		super(new IsModifiedMixin());
	}
}

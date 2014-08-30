package org.yq.spring.ch4.mi;

public class StandardLookupDemoBean implements DemoBean {
	private MyHelper myHelper;

	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}

	public MyHelper getMyHelper() {
		return myHelper;
	}

	public void someOperation() {
		myHelper.doSomethingHelpful();

	}

}

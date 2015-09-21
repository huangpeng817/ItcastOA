package cn.itcast.oa.test;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestAction.execute()");
		return "success";
	}
}

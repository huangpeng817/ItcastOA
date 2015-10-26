package cn.itcast.oa.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.itcast.oa.domain.User;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 3123353315475003316L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// System.out.println("CheckPrivilegeInterceptor.intercept()之前");
		// String result = invocation.invoke(); // 放行, 返回到响应的result结果视图，如saveUI
		// System.out.println("CheckPrivilegeInterceptor.intercept()之后");
		// System.out.println("result: " + result);
		// return result;

		// 获取信息
		User user = (User) ActionContext.getContext().getSession().get("user");
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privUrl = namespace + actionName;
		
		// 如果未登录
		if (user == null) {
			if (privUrl.startsWith("/user_login")) {
				// 如果是去登录，就放行
				return invocation.invoke();
				
			} else {
				// 如果不是去登录，就转到登录页面
				return "loginUI";
			}
			// 如果已登录，就判断权限
		} else {
			
			if (user.hasPrivilegeByUrl(privUrl)) {
				// 如果有权限，就放行
				return invocation.invoke();	
			} else {
				// 如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}
	}

}

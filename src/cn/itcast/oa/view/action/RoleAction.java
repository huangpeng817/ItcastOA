package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport {

	public String list() throws Exception {
		return "list";
	}
	public String delete() throws Exception {
		return "toList";
	}
	public String addUI() throws Exception {
		return "addUI";
	}
	public String add() throws Exception {
		return "toList";
	}
	public String editUI() throws Exception {
		return "editUI";
	}
	public String edit() throws Exception {
		return "toList";
	}
}

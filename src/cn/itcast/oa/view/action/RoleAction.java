package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {

	@Resource
	RoleService roleService;
	private Long id; // Struts2的Action是使用成员变量接收参数（有getter和setter方法）
	private String name;
	private String description;
	
	@Override
	public Role getModel() {
		return null;
	}

	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	public String delete() throws Exception {
		System.out.println("RoleAction.delete()");
		roleService.delete(id);
		return "toList";
	}
	public String addUI() throws Exception {
		return "addUI";
	}
	public String add() throws Exception {
		Role role = new Role();
		role.setName(name);
		role.setDescription(description);
		roleService.save(role);
		return "toList";
	}
	public String editUI() throws Exception {
		Role role = roleService.getById(id);
		ActionContext.getContext().getValueStack().push(role); // 将role对象放在值栈的栈顶，然后回显所需数据从栈顶中得到
//		this.name = role.getName();
//		this.description = role.getDescription();
		return "editUI";
	}
	public String edit() throws Exception {
		Role role = roleService.getById(id);
		role.setName(name);
		role.setDescription(description);
		roleService.update(role);
		return "toList";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

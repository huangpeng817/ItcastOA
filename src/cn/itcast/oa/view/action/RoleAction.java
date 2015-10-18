package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	
	private Long[] privilegeIds;

	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	public String delete() throws Exception {
		System.out.println("RoleAction.delete()");
		roleService.delete(model.getId());
		return "toList";
	}
	public String addUI() throws Exception {
		return "saveUI";
	}
	public String add() throws Exception {
//		Role role = new Role();
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
//		roleService.save(role);
		roleService.save(model); // model中已经包含了name和description两个属性，不用新的role传递值多此一举
		return "toList";
	}
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role); // 将role对象放在值栈的栈顶，然后回显所需数据从栈顶中得到
//		this.name = role.getName();
//		this.description = role.getDescription();
		return "saveUI";
	}
	public String edit() throws Exception {
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
	public String setPrivilegeUI() throws Exception {
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role); // 将role对象放在值栈的栈顶，然后回显所需数据从栈顶中得到
		if (role.getPrivileges() != null) {
			privilegeIds = new Long[role.getPrivileges().size()];
			int index = 0;
			for (Privilege priv : role.getPrivileges()) {
				privilegeIds[index++] = priv.getId();
			}
		}
		
		List<Privilege> privilegeList = privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		
		return "setPrivilegeUI";
	}
	public String setPrivilege() throws Exception {
		Role role = roleService.getById(model.getId());
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		roleService.update(role);
		return "toList";
	}
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
}

package cn.itcast.oa.view.action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.util.DepartmentUtils;
import cn.itcast.oa.util.QueryHelper;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	// ---model不能封装的参数(参数类型不匹配所接收的前台参数)
	private Long departmentId;
	private Long[] roleIds;
	
	public String list() throws Exception {
//		List<User> userList = userService.findAll();
//		ActionContext.getContext().put("userList", userList);
		
		// 准备分页信息
		new QueryHelper(User.class, "u").preparePageBean(userService, pageNum, pageSize);
		
		return "list"; 
	}
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		
		return "saveUI";
	}
	public String add() throws Exception {
		model.setDepartment(departmentService.getById(departmentId));
//		model.setRoles(new HashSet<Role>(roleService.getByIds(roleIds)));
		List<Role> roleList = roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		String md5Digest = DigestUtils.md5Hex("1234");
		model.setPassword(md5Digest);
		userService.save(model);
		return "toList";
	}
	public String edit() throws Exception {
		User user = userService.getById(model.getId());
		
		user.setDepartment(departmentService.getById(departmentId));
//		user.setDepartment(model.getDepartment());
		user.setDescription(model.getDescription());
		user.setEmail(model.getEmail());
		user.setGender(model.getGender());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);
		user.setPhoneNumber(model.getPhoneNumber());
		List<Role> roleList = roleService.getByIds(roleIds);
		
		// 将List集合转换成Set集合
		// 方式一：
		user.setRoles(new HashSet<Role>(roleList));
		// 方式二：
//		Set<Role> roles = new HashSet<Role>();
//		roles.addAll(roleList);
		
		userService.update(user);
		
		return "toList";
	}
	public String editUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		
		// 回显用户的基本数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		// 回显部门列表和岗位列表
		if (user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		if (user.getRoles() != null) {
			Set<Role> roles = user.getRoles();
			roleIds = new Long[roles.size()];
			int i = 0;
			for (Role role : roles) {
				roleIds[i++] = role.getId();
			}
		}
		
		return "saveUI";
	}
	public String initPassword() throws Exception {
		User user = userService.getById(model.getId());
		String md5Digest = DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);
		userService.update(user);
		return "toList";
	}
	
	public String loginUI() throws Exception {
		return "loginUI";
	}
	public String login() throws Exception {
		String md5Digest = DigestUtils.md5Hex(model.getPassword());
		User user = userService.findByLoginNameAndPassword(model.getLoginName(), md5Digest);
		if (user == null) {
			addFieldError("login", "用户名或者密码不正确！");
			return "loginUI";
		} else {
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
	}
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	// --- getters and setters
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
}

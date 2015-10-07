package cn.itcast.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;
import cn.itcast.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	@Resource
	DepartmentService departmentService;
	
	private Long parentId;
	
	private Department model = new Department(); // 实现ModelDriven接口的model对象封装了请求参数
	
	@Override
	public Department getModel() {
		return model;
	}
	
	public String list() throws Exception {
		List<Department> departmentList = null;
		
		if (parentId == null) { // 顶级部门列表
			departmentList = departmentService.findTopList();
		} else { // 子部门列表
			// 保存准备返回到上一级的parent数据（OGNL访问#parent.parent.id）
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
			
			departmentList = departmentService.findChildren(parentId);
		}
		
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}
	
	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}
	
	public String add() throws Exception {
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}
	
	public String editUI() throws Exception {
		// 准备departmentList数据（下拉列表）
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		// 准备回显部门的基本信息
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department); // 将要修改的对象放在栈顶，自动找到属性回显
		
		// 回显parentId数据
		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		
		return "saveUI";
	}
	
	public String edit() throws Exception {
		Department department = departmentService.getById(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);
		departmentService.update(department);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}

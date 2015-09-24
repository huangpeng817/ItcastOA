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

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	@Resource
	DepartmentService departmentService;
	
	private Department model = new Department(); // 实现ModelDriven接口的model对象封装了请求参数
	
	@Override
	public Department getModel() {
		return model;
	}
	
	public String list() throws Exception {
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}
	
	public String addUI() throws Exception {
		return "saveUI";
	}
	
	public String add() throws Exception {
		departmentService.save(model);
		return "toList";
	}
	
	public String editUI() throws Exception {
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department); // 将要修改的对象放在栈顶，自动找到属性回显
		return "saveUI";
	}
	
	public String edit() throws Exception {
		Department department = departmentService.getById(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		departmentService.update(department);
		return "toList";
	}

}

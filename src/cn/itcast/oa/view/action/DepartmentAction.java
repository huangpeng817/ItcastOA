package cn.itcast.oa.view.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	@Resource
	DepartmentService departmentService;
	
	private Department department = new Department();
	
	@Override
	public Department getModel() {
		return department;
	}
	
	public String list() throws Exception {
		
		return "list";
	}
	
	public String delete() throws Exception {
		return "delete";
	}
	
	public String addUI() throws Exception {
		return "saveUI";
	}
	
	public String add() throws Exception {
		return "toList";
	}
	
	public String editUI() throws Exception {
		return "saveUI";
	}
	
	public String edit() throws Exception {
		return "toList";
	}

}

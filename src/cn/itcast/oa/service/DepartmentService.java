package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Department;

public interface DepartmentService extends DaoSupport<Department> {

//	List<Department> findAll();
//
//	void save(Department model);
//
//	Department getById(Long id);
//
//	void update(Department department);
//
//	void delete(Long id);
//
	List<Department> findTopList();

	List<Department> findChildren(Long parentId);

}

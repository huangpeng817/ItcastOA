package cn.itcast.oa.dao;

import java.util.List;

import cn.itcast.oa.domain.Department;
@Deprecated
public interface DepartmentDao {

	List<Department> findAll();

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	void delete(Long id);

}

package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@Scope
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	DepartmentDao departmentDao;
	
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void save(Department model) {
		departmentDao.save(model);
	}

	@Override
	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}

	@Override
	public void delete(Long id) {
		departmentDao.delete(id);
	}

}

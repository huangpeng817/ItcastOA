package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.dao.DepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.DepartmentService;

@Service
@Scope("prototype")
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

	
	
	@Resource
	SessionFactory sessionFactory; // 不采用service啥都不干的方式，只是调用dao层，暂时在service层注入sessionFactory进行数据库操作
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findTopList() {
		// 之前的方式，注入sessionFactory，sessionFactory的实例只有一个
//		return sessionFactory.getCurrentSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
		// 现在的方式，因为父类DaoSupportImpl中已经注入了sessionFactory已经注入了，和当前类中注入的sessionFactory是一个实例
		return getSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findChildren(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery("FROM Department d WHERE d.parent.id=?")
				.setParameter(0, parentId)
				.list();
	}
	
//	@Resource
//	DepartmentDao departmentDao;
//	
//	@Override
//	public List<Department> findAll() {
//		return departmentDao.findAll();
//	}
//
//	@Override
//	public void save(Department model) {
//		departmentDao.save(model);
//	}
//
//	@Override
//	public Department getById(Long id) {
//		return departmentDao.getById(id);
//	}
//
//	@Override
//	public void update(Department department) {
//		departmentDao.update(department);
//	}
//
//	@Override
//	public void delete(Long id) {
//		departmentDao.delete(id);
//	}

}

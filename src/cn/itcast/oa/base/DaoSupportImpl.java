package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.util.PageBean;

//添加对删改的事务处理，让session处于事物的管理下
@Transactional
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;

	private Class<T> clazz;
	// private Type type;

	@SuppressWarnings("unchecked")
	public DaoSupportImpl() {
		// 获取当前new的对象的 泛型的父类 类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型,其实就是代表<T>泛型参数有且只有一个，如果是Map<K,V>就是参数数组(两个值)
		// this.type = pt.getActualTypeArguments()[0];
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; 
		// System.out.println("当前的clazz：\t" + type);
		/**
		 * 每次启动tomcat都打印所有实体的这句话，是因为现在方案都是**ServiceImpl.java继承DaoSupportImpl
		 * 并且所有的***ServiceImpl的bean通过@Service注解托管到Spring容器进行管理，就和直接在applicationContext.xml
		 * 中通过<bean>元素声明一样
		 */
		System.out.println("DaoSupportImpl.DaoSupportImpl().clazz：\t" + clazz);
	}

	/*
	 * 获取当前可用的session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
//			return new ArrayList<T>();
		} else {
			return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")
					.setParameterList("ids", ids).list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	// 公共的查询分页信息的方法
	@Override
	public PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters) {
		
		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(hql); // 创建查询对象
		if (parameters != null) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // 执行查询
		
		// 查询总记录条数
		Query countQuery = getSession().createQuery("SELECT COUNT(*)" + hql);
		if (parameters != null) {
			int index = 0;
			for (Object object : parameters) {
				countQuery.setParameter(index, object);
				index = index + 1;
			}
		}
		Long recordCount = (Long) countQuery.uniqueResult();
		
		return new PageBean(pageNum, pageSize, recordCount.intValue(), list);
	}
	
}

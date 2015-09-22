package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;

	private Class<T> clazz;
	// private Type type;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 获取当前new的对象的 泛型的父类 类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取第一个类型参数的真实类型,其实就是代表<T>泛型参数有且只有一个，如果是Map<K,V>就是参数数组(两个值)
		// this.type = pt.getActualTypeArguments()[0];
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; 
		// System.out.println("当前的clazz：\t" + type);
		System.out.println("当前的clazz：\t" + clazz);
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
		// getSession().get((Class) type, id);
		getSession().get(clazz, id);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByIds(Long[] ids) {
		return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")
				.setParameterList("ids", ids).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

}

package cn.itcast.oa.base;

import java.util.List;

import cn.itcast.oa.util.PageBean;

public interface DaoSupport<T> {
	void save(T entity);

	void delete(Long id);

	void update(T entity); // 更新函数形参是对象

	T getById(Long id);

	List<T> getByIds(Long[] ids);

	List<T> findAll();
	
	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param hql
	 * @param parameters
	 * 			参数列表，其HQL中?一一对应
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters);

}

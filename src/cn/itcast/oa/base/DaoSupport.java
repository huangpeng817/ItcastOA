package cn.itcast.oa.base;

import java.util.List;

import cn.itcast.oa.util.PageBean;
import cn.itcast.oa.util.QueryHelper;

public interface DaoSupport<T> {
	void save(T entity);

	void delete(Long id);

	void update(T entity); // 更新函数形参是对象

	T getById(Long id);

	List<T> getByIds(Long[] ids);

	List<T> findAll();
	
	/**
	 * 公共的查询分页信息的方法
	 * @param pageNum
	 * @param pageSize
	 * @param hql
	 * @param parameters
	 * 			参数列表，其HQL中?一一对应
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters);
	
	/**
	 * 公共的查询分页信息的方法（最终版）
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper 
	 * 			HQL语句与参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}

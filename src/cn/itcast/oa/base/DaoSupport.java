package cn.itcast.oa.base;

import java.util.List;

public interface DaoSupport<T> {
	void save(T entity);

	void delete(Long id);

	void update(T entity); // 更新函数形参是对象

	T getById(Long id);

	List<T> getByIds(Long[] ids);

	List<T> findAll();
}

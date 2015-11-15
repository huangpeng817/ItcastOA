package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.DaoSupport;

public class QueryHelper {

	private String fromClause; // FROM子句
	private String whereClause = ""; // WHERE
	private String orderByClause = ""; // ORDER BY子句
	
	private List<Object> parameters = new ArrayList<Object>(); // 参数列表
	
	/**
	 * 生成from子句
	 * @param clazz 实体类型
	 * @param alias 别名
	 */
	public QueryHelper(Class clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias; // FROM User u
	}
	
	/**
	 * 拼接Where子句
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(String condition, Object... params) {
		// 拼接
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause += " AND " + condition;
		}
		
		// 参数
		if (params != null) {
			for (Object param : params) {
				parameters.add(param);
			}
		}
		return this;
	}
	
	/**
	 * 如果第一个参数append为true,则拼接Where子句
	 * @param append
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(boolean append, String condition, Object... params) {
		if (append) {
			addCondition(condition, params);
		}
		return this;
	}
	
	/**
	 * 
	 * @param propertyName
	 * 			参与排序的属性名
	 * @param asc
	 * 			true表示升序，false表示降序
	 */
	public QueryHelper addOrderProperty(String propertyName, boolean asc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (asc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (asc ? " ASC" : " DESC");
		}
		return this;
	}
	
	/**
	 * 如果第一个参数append为true,则拼接order by子句
	 * @param append
	 * @param propertyName
	 * @param asc
	 */
	public QueryHelper addOrderProperty(boolean append, String propertyName, boolean asc) {
		if (append) {
			addOrderProperty(propertyName, asc);
		}
		return this;
	}
	
	/**
	 * 获取生成的用于查询数据列表的HQL语句
	 * @return
	 */
	public String getListQueryHql() {
		return fromClause + whereClause + orderByClause;
	}
	
	/**
	 * 获取生成的用于查询数据列表的HQL语句
	 * @return
	 */
	public String getCountQueryHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	/**
	 * 获取HQL中的参数值列表
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}
	
	/**
	 * 查询分页信息，并放到值栈栈顶
	 * @param service
	 * @param pageNum
	 * @param pageSize
	 */
	public void preparePageBean(DaoSupport<?> service, int pageNum, int pageSize) {
		PageBean pageBean = service.getPageBean(pageNum, pageSize, this);
		ActionContext.getContext().getValueStack().push(pageBean);
	}
}

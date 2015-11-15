package cn.itcast.oa.util;

import java.util.ArrayList;
import java.util.List;

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
	public void addCondition(String condition, Object... params) {
		// 拼接
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause = " AND " + condition;
		}
		
		// 参数
		if (params != null) {
			for (Object param : params) {
				parameters.add(param);
			}
		}
	}
	
	/**
	 * 
	 * @param propertyName
	 * 			参与排序的属性名
	 * @param asc
	 * 			true表示升序，false表示降序
	 */
	public void addOrderProperty(String propertyName, boolean asc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (asc ? "ASC" : "DESC");
		} else {
			orderByClause += ", " + propertyName + (asc ? "ASC" : "DESC");
		}
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
		return "SELECT COUNT(*) " + whereClause + orderByClause;
	}
	
	/**
	 * 获取HQL中的参数值列表
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}
}

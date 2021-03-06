package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.PageBean;

public interface TopicService extends DaoSupport<Topic> {

	/**
	 * 查询指定板块中的所有主题，排序：所有置顶帖在最上面，同一个类型的按照最后更新时间排序，使新状态的在上面
	 * @param forum
	 * @return
	 */
	@Deprecated
	List<Topic> findByForum(Forum forum);

	/**
	 * 查询分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param forum
	 * @return
	 */
	@Deprecated
	PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum);

}

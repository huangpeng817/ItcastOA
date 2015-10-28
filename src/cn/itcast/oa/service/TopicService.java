package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

public interface TopicService extends DaoSupport<Topic> {

	/**
	 * 查询指定板块中的所有主题，排序：所有置顶帖在最上面，同一个类型的按照最后更新时间排序，使新状态的在上面
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

}

package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

public interface ReplyService extends DaoSupport<Reply> {

	/**
	 * 通过指定主题获取回帖列表：按照发表时间先后顺序排序
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);

}

package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.ReplyService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService {

	@Override
	public List<Reply> findByTopic(Topic topic) {
		return getSession().createQuery( //
				"FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC") //
				.setParameter(0, topic) //
				.list();
	}
	
	/**
	 * 重写save方法，维护相关的特殊属性
	 */
	@Override
	public void save(Reply reply) {
		super.save(reply);
		
		// 维护相关的特殊属性
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		
		forum.setArticleCount(forum.getArticleCount() + 1);
		topic.setReplyCount(topic.getReplyCount() + 1);
		topic.setLastReply(reply);
		topic.setLastUpdateTime(reply.getPostTime());
		
		// 更新到数据库中
		getSession().update(topic);
		getSession().update(forum);
	}

}

package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.service.TopicService;
import cn.itcast.oa.util.PageBean;

@Service
@Transactional
public class TopicServiceImpl extends DaoSupportImpl<Topic>implements TopicService {

	@Override
	@Deprecated
	public List<Topic> findByForum(Forum forum) {
		// 排序：所有置顶帖在最上面，,其他精华帖和普通贴类型的按照最后更新时间排序，使新状态的在上面
		// TODO 怎么排序？
		return getSession()
				.createQuery( //
						"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC") //
				.setParameter(0, forum) //
				.list();
	}
	
	@Override
	public void save(Topic topic) {
		// 1.设置属性并保存
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getPostTime());
//		topic.setReplies(replies);
		topic.setReplyCount(0);
		topic.setType(Topic.TYPE_NORMAL);
		
		getSession().save(topic); // 保存
		
		// 2.维护相关的特殊属性
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1); // 主题数量
		forum.setArticleCount(forum.getArticleCount() + 1); // 文章数量
		forum.setLastTopic(topic); // 最后发表的主题
		getSession().update(forum);  // 将修改的forum更新到数据库中
	}

	@Override
	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum) {
		
		// 查询本页的数据列表
		List recordList = getSession().createQuery( //
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC") //
				.setParameter(0, forum) //
				.setFirstResult((pageNum - 1) * pageSize) //
				.setMaxResults(pageSize) //
				.list();
		
		// 查询总记录条数
		Long recordCount = (Long) getSession().createQuery( //
				"SELECT COUNT(*) FROM Topic t WHERE t.forum=?") //
				.setParameter(0, forum) //
				.uniqueResult();
		
		return new PageBean(pageNum, pageSize, recordCount.intValue(), recordList);
	}

}

package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.PageBean;

public interface ReplyService extends DaoSupport<Reply> {

	/**
	 * 通过指定主题获取回帖列表：按照发表时间先后顺序排序
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);

	/**
	 * 查询分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param topic
	 * @return
	 */
	PageBean getPageBeanByTopic(int pageNum, int pageSize, Topic topic);

}

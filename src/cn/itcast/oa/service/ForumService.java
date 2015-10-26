package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.Forum;

public interface ForumService extends DaoSupport<Forum> {

	/**
	 * 板块上移
	 * @param id
	 */
	void moveUp(Long id);

	/**
	 * 板块下移
	 * @param id
	 */
	void moveDown(Long id);

}

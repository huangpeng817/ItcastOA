package cn.itcast.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.DaoSupportImpl;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl extends DaoSupportImpl<Forum> implements ForumService {

	/**
	 * 重写findAll方法,以position字段升序显示
	 */
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum f ORDER BY f.position").list();
	}
	
	/**
	 * 重写save方法，新增板块就设置position的值，将值设置和id同一个值
	 */
	@Override
	public void save(Forum forum) {
		super.save(forum);
		forum.setPosition(forum.getId().intValue());
	}
	
	@Override
	public void moveUp(Long id) {
		Forum forum = getById(id); // 当前要上移的forum
		Forum other = (Forum) getSession().createQuery( // 紧邻这准备上移的上一个forum
				"FROM Forum f WHERE f.position < ? ORDER BY f.position DESC") //
				.setParameter(0, forum.getPosition()) //
				.setFirstResult(0) //
				.setMaxResults(1) //
				.uniqueResult(); //
		if (other == null) {
			return;
		}
		int temp = forum.getPosition(); // 准备交换的临时变量
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
		// 更新到数据库中（可以不写，因为对象现在是持久化状态）
		getSession().update(forum);
		getSession().update(other);
		
	}

	@Override
	public void moveDown(Long id) {
		Forum forum = getById(id); // 当前要下移的forum
		Forum other = (Forum) getSession().createQuery( // 紧邻这准备下移的下一个forum
				"FROM Forum f WHERE f.position > ? ORDER BY f.position ASC") //
				.setParameter(0, forum.getPosition()) //
				.setFirstResult(0) //
				.setMaxResults(1) //
				.uniqueResult(); //
		if (other == null) {
			return;
		}
		int temp = forum.getPosition(); // 准备交换的临时变量
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		
	}

}

package cn.itcast.oa.view.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.PageBean;
import cn.itcast.oa.util.QueryHelper;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	private static final long serialVersionUID = 5519080617926673475L;
	
	/**
	 * 0 全部主题
	 * 1 全部精华贴
	 */
	private int viewType = 0;
	/**
	 * 0 默认排序（按最后更新时间排序，但所有置顶帖都在前面）
	 * 1 按最后更新时间排序                     
	 * 2 按主题发表时间排序                   
	 * 3 按回复数量排序                       
	 */
	private int orderBy = 0;
	/**
	 * false 降序
	 * true 升序
	 * 
	 */
	private boolean asc = false;
	
	/** 显示板块列表 */
	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	
	/** 显示单个板块（主题列表） */
	public String show() throws Exception {
		// 显示导航条 > 论坛 > 销售常见问题 中的数据
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		
//		List<Topic> topicList = topicService.findByForum(forum);
//		ActionContext.getContext().put("topicList", topicList);
		
//		// 准备分页信息v1
//		PageBean pageBean = topicService.getPageBeanByForum(pageNum, pageSize, forum);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
//		// 准备分页信息v2
//		String hql = "FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
//		List<Object> parameters = new ArrayList<Object>();
//		parameters.add(forum);
//		PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
//		// 准备分页信息v3
//		String hql = "FROM Topic t WHERE t.forum=? ";
//		List<Object> parameters = new ArrayList<Object>();
//		parameters.add(forum);
//		
//		if (viewType == 1) { // 1 只看精华帖
//			hql += " AND t.type=? ";
//			parameters.add(Topic.TYPE_BEST);
//		}
//		
//		if (orderBy == 1) { // 1 按最后更新时间排序 
//			hql += " ORDER BY t.lastUpdateTime " + (asc ? "ASC" : "DESC");
//		} else if (orderBy == 2) { // 2 按主题发表时间排序   
//			hql += " ORDER BY t.postTime " + (asc ? "ASC" : "DESC");
//		} else if (orderBy == 3) { // 3 按回复数量排序            
//			hql += " ORDER BY t.replyCount " + (asc ? "ASC" : "DESC");
//		} else { // 0 默认排序（按最后更新时间排序，但所有置顶帖都在前面）
//			hql += " ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
//		}
//		
//		PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		// 准备分页信息, 最终版
		new QueryHelper(Topic.class, "t") // 
				// 过滤条件
				.addCondition("t.forum=?", forum) //
				.addCondition((viewType == 1), "t.type=?", Topic.TYPE_BEST) // 1 只看精华帖
				// 排序条件
				.addOrderProperty((orderBy == 1), "t.lastUpdateTime", asc) // 1 按最后更新时间排序
				.addOrderProperty((orderBy == 2), "t.postTime", asc)// 2 按主题发表时间排序
				.addOrderProperty((orderBy == 3), "t.replyCount", asc)// 3 按回复数量排序
				.addOrderProperty((orderBy == 0), "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)// 0 默认排序（按最后更新时间排序，但所有置顶帖都在前面）
				.addOrderProperty((orderBy == 0), "t.lastUpdateTime", false) //
				.preparePageBean(topicService, pageNum, pageSize)
		;
		
		return "show";
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}
	
}

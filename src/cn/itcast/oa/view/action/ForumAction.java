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

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	private static final long serialVersionUID = 5519080617926673475L;
	
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
		
		// 准备分页信息v2
		String hql = "FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(forum);
		PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "show";
	}

}

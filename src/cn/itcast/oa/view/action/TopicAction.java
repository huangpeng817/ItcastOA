package cn.itcast.oa.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;
import cn.itcast.oa.util.PageBean;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	private static final long serialVersionUID = 5988876514465199171L;
	private Long forumId;
	
	/** 显示单个主题（主贴+回帖列表） */
	public String show() throws Exception {
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
//		List<Reply> replyList = replyService.findByTopic(topic);
//		ActionContext.getContext().put("replyList", replyList);
		
//		// 准备分页信息 v1
//		PageBean pageBean = replyService.getPageBeanByTopic(pageNum, pageSize, topic);
//		ActionContext.getContext().getValueStack().push(pageBean);
		
		// 准备分页信息 v2
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(topic);
		PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "show";
	}
	
	/** 发新帖UI */
	public String addUI() throws Exception {
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	/** 发新帖 */
	public String add() throws Exception {
		// > model封装好的参数
//		model.setContent(content);
//		model.setTitle(title);
		model.setForum(forumService.getById(forumId));

		// > 当前直接获取的信息
		model.setAuthor(this.getCurrentUser()); // 当前登录用户
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr()); // 当前请求的IP(Servlet中的方法)
		System.out.println(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date()); // 当前时间
		
		topicService.save(model);
		
		return "toShow";
	}

	// ---
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

}

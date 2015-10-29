package cn.itcast.oa.view.action;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	private static final long serialVersionUID = 7961379570124030060L;
	
	private Long topicId;
	
	/** 回帖UI */
	public String addUI() throws Exception {
		
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		
		return "addUI";
	}
	
	/** 回帖 */
	public String add() throws Exception {
		
		// > model封装好的参数
//		model.setContent(content);
//		model.setTitle(title);
		model.setTopic(topicService.getById(topicId));
		
		// > 当前直接获取的信息
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		
		replyService.save(model);
		
		return "toTopicShow";
	}

	// ----
	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}

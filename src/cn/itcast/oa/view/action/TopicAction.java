package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Topic;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	private static final long serialVersionUID = 5988876514465199171L;
	
	/** 显示单个主题（主贴+回帖列表） */
	public String execute() throws Exception {
		return "show";
	}
	
	/** 发新帖UI */
	public String addUI() throws Exception {
		return "addUI";
	}
	
	/** 发新帖 */
	public String add() throws Exception {
		return "toShow";
	}

}

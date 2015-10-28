package cn.itcast.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	private static final long serialVersionUID = 7961379570124030060L;
	
	/** 回帖UI */
	public String addUI() throws Exception {
		return "addUI";
	}
	
	/** 回帖 */
	public String add() throws Exception {
		return "toTopicShow";
	}

}

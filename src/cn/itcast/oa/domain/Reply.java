package cn.itcast.oa.domain;

public class Reply extends Article {

	private Topic topic; // 该回复属于的主题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}

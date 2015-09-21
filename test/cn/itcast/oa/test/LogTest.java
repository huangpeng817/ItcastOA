package cn.itcast.oa.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogTest {

	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Test
	public void test() throws Exception {
		log.debug("debug信息");
		log.info("info信息");
		log.warn("warn信息");
		log.error("error信息");
		log.fatal("fatal信息");
	}
}

package cn.itcast.oa.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.itcast.oa.domain.Forum;
import cn.itcast.oa.domain.Topic;

public class QueryHelperTest {

	/**
	 * 0 全部主题 1 全部精华贴
	 */
	private int viewType = 1;
	/**
	 * 0 默认排序（按最后更新时间排序，但所有置顶帖都在前面） 1 按最后更新时间排序 2 按主题发表时间排序 3 按回复数量排序
	 */
	private int orderBy = 0;
	/**
	 * false 降序 true 升序
	 * 
	 */
	private boolean asc = false;

	private Forum forum = new Forum();

	@Test
	public void testQueryHelper() {

		QueryHelper queryHelper = new QueryHelper(Topic.class, "t") //
				// 过滤条件
				.addCondition("t.forum=?", forum) //
				.addCondition((viewType == 1), "t.type=?", Topic.TYPE_BEST) // 1 只看精华帖
				// 排序条件
				.addOrderProperty((orderBy == 1), "t.lastUpdateTime", asc) // 1 按最后更新时间排序
				.addOrderProperty((orderBy == 2), "t.postTime", asc)// 2 按主题发表时间排序
				.addOrderProperty((orderBy == 3), "t.replyCount", asc)// 3 按回复数量排序
				.addOrderProperty((orderBy == 0), "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)// 0 默认排序（按最后更新时间排序，但所有置顶帖都在前面）
				.addOrderProperty((orderBy == 0), "t.lastUpdateTime", false)
		;
		
		System.out.println(queryHelper.getListQueryHql());
		System.out.println(queryHelper.getCountQueryHql());
		System.err.println(queryHelper.getParameters());
	}

}

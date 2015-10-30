<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head>
	<title>【${forum.name }】中的主题列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" border="0" height="13" width="13"> 【${forum.name }】中的主题列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%;">
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forum_list">论坛</s:a>
			<font class="MenuPoint"> &gt; </font>
			${forum.name }
			<span style="margin-left:30px;"><s:a action="topic_addUI?forumId=%{#forum.id}">
				<img src="${pageContext.request.contextPath }/style/blue/images/button/publishNewTopic.png" align="absmiddle"></s:a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<!--表头-->
				<tbody><tr align="center" valign="middle">
					<td class="ForumPageTableTitleLeft" width="3">
						<img src="${pageContext.request.contextPath }/style/images/blank.gif" border="0" height="1" width="1">
					</td>
					<td class="ForumPageTableTitle" width="50"><!--状态/图标-->&nbsp;</td>
					<td class="ForumPageTableTitle">主题</td>
					<td class="ForumPageTableTitle" width="130">作者</td>
					<td class="ForumPageTableTitle" width="100">回复数</td>
					<td class="ForumPageTableTitle" width="130">最后回复</td>
					<td class="ForumPageTableTitleRight" width="3">
						<img src="${pageContext.request.contextPath }/style/images/blank.gif" border="0" height="1" width="1">
					</td>
				</tr>
				<tr class="ForumPageTableTitleLine" height="1"><td colspan="8"></td></tr>
				<tr height="3"><td colspan="8"></td></tr>
					
				<!--主题列表-->
				</tbody>
				<tbody class="dataContainer" datakey="topicList">
					<s:iterator value="recordList">
					<tr class="demodata_record" id="d0" height="35">
						<td></td>
						<td class="ForumTopicPageDataLine" align="center"><img src="${pageContext.request.contextPath }/style/images/topicType_${type }.gif"></td>
						<td class="Topic"><s:a cssClass="Default" action="topic_show?id=%{id}">${title }</s:a></td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${author.name }</li>
								<li class="CreateTime">${postTime }</li>
							</ul>
						</td>
						<td class="ForumTopicPageDataLine Reply" align="center"><b>${replyCount }</b></td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${lastReply.author.name }</li>
								<li class="CreateTime">${lastReply.postTime }</li>
							</ul>
						</td>
						<td></td>
					</tr>
					</s:iterator>
				</tbody>
					<!--主题列表结束-->	
						
					<tbody><tr height="3"><td colspan="9"></td></tr>
				
			</tbody></table>
			
			<!--其他操作-->
			<div id="TableTail">
				<div id="TableTail_inside">
					<table align="left" border="0" cellpadding="0" cellspacing="0" height="100%">
						<tbody><tr valign="bottom">
							<td></td>
							<td><select name="viewType">
									<option value="0">全部主题</option>
									<option value="1">全部精华贴</option>
									<!--
									<option value="2">当天的主题</option>
									<option value="3">本周的主题</option>
									<option value="4">本月的主题</option>
									-->
								</select>
								<select name="orderBy">
									<option value="0">默认排序（按最后更新时间排序，但所有置顶帖都在前面）</option>
									<option value="1">按最后更新时间排序</option>
									<option value="2">按主题发表时间排序</option>
									<option value="3">按回复数量排序</option>
								</select>
								<select name="reverse">
									<option value="true">降序</option>
									<option value="false">升序</option>
								</select>
								<input src="${pageContext.request.contextPath }/style/blue/images/button/submit.PNG" align="ABSMIDDLE" type="IMAGE">
							</td>
						</tr>
					</tbody></table>
				</div>
			</div>
			
		</div>
	</center>
</div>

<!--分页信息-->
<%@include file="/WEB-INF/jsp/public/pageView.jspf" %>

<script type="text/javascript">
	
	function gotoPage(pageNum) {
		window.location.href = "forum_show.action?id=${id}&pageNum=" + pageNum;
	}
</script>

<div class="Description">
	说明：<br>
	1，主题默认按最后更新的时间降序排列。最后更新时间是指主题最后回复的时间，如果没有回复，就是主题发表的时间。<br>
	2，帖子有普通、置顶、精华之分。置顶贴始终显示在最上面，精华贴用不同的图标标示。<br>
</div>



</body></html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head>
	<title>查看主题：新手发帖</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	
	<script language="javascript" src="${pageContext.request.contextPath }/script/fckeditor/fckeditor.js" charset="utf-8"></script>
    <script type="text/javascript">
		$(function(){
			var fck = new FCKeditor("content");
			fck.Width = "90%";
			fck.ToolbarSet = "bbs";
			fck.BasePath = "${pageContext.request.contextPath }/script/fckeditor/";
			fck.ReplaceTextarea();
		});
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" border="0" height="13" width="13"> 查看主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--内容显示-->	
<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%">
			<font class="MenuPoint"> &gt; </font>
			<a href="${pageContext.request.contextPath }/BBS_Forum/forumList.html">论坛</a>
			<font class="MenuPoint"> &gt; </font>
			<a href="${pageContext.request.contextPath }/BBS_Forum/forumShow.html">客服常见问题</a>
			<font class="MenuPoint"> &gt;&gt; </font>
			帖子阅读
			<span style="margin-left:30px;"><a href="saveUI.html">
				<img src="${pageContext.request.contextPath }/style/blue/images/button/publishNewTopic.png" align="absmiddle"></a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder dataContainer" datakey="replyList">
		
			<!--显示主题标题等-->
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tbody><tr valign="bottom">
				<td class="ForumPageTableTitleLeft" width="3">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>本帖主题：新手发帖</b></td>
					<td class="ForumPageTableTitle" style="padding-right:12px;" align="right">
						<a class="detail" href="${pageContext.request.contextPath }/BBS_Reply/saveUI.html"><img src="${pageContext.request.contextPath }/style/images/reply.gif" border="0">回复</a>
						<a href="moveUI.html"><img src="${pageContext.request.contextPath }/style/images/edit.gif" border="0">移动到其他版块</a>
						<a href="#" onclick="return confirm('要把本主题设为精华吗？')"><img src="${pageContext.request.contextPath }/style/images/forum_hot.gif" border="0">精华</a>
						<a href="#" onclick="return confirm('要把本主题设为置顶吗？')"><img src="${pageContext.request.contextPath }/style/images/forum_top.gif" border="0">置顶</a>
						<a href="#" onclick="return confirm('要把本主题设为普通吗？')"><img src="${pageContext.request.contextPath }/style/images/forum_comm.gif" border="0">普通</a>
					</td>
					<td class="ForumPageTableTitleRight" width="3">&nbsp;</td>
				</tr>
				<tr class="ForumPageTableTitleLine" height="1"><td colspan="4"></td></tr>
			</tbody></table>

			<!-- ~~~~~~~~~~~~~~~ 显示主帖 ~~~~~~~~~~~~~~~ -->
			<div class="ListArea">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tbody><tr>
						<td rowspan="3" class="PhotoArea" align="center" valign="top" width="130">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif" onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';" border="0" height="110" width="110">
							</div>
							<!--作者名称-->
							<div class="AuthorName">管理员</div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href="${pageContext.request.contextPath }/BBS_Topic/saveUI.html"><img src="${pageContext.request.contextPath }/style/images/edit.gif" border="0">编辑</a>
									<a class="detail" href="#" onclick="return confirm('确定要删除本帖吗？')"><img src="${pageContext.request.contextPath }/style/images/delete.gif" border="0">删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img src="${pageContext.request.contextPath }/style/images/face/face1.gif" height="19" width="19">
									新手发帖
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td align="center" valign="top">
							<div class="Content">好好学习，天天向上！</div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" align="center" height="28" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color="#C30000">[楼主]</font>
									2007-08-17 15:18
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img src="${pageContext.request.contextPath }/style/images/top.gif" border="0"></a>
								</li>
							</ul>
						</td>
					</tr>
				</tbody></table>
			</div>
			<!-- ~~~~~~~~~~~~~~~ 显示主帖结束 ~~~~~~~~~~~~~~~ -->


			<!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
			
			<!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
		<div class="ListArea demodata_record">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tbody><tr>
						<td rowspan="3" class="PhotoArea" align="center" valign="top" width="130">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif" onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';" border="0" height="110" width="110">
							</div>
							<!--作者名称-->
							<div class="AuthorName">管理员</div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href="${pageContext.request.contextPath }/BBS_Topic/saveUI.html"><img src="${pageContext.request.contextPath }/style/images/edit.gif" border="0">编辑</a>
									<a class="detail" href="#" onclick="return confirm('确定要删除本帖吗？')"><img src="${pageContext.request.contextPath }/style/images/delete.gif" border="0">删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img src="${pageContext.request.contextPath }/style/images/face/face2.gif" height="19" width="19">
									回复：新手发帖
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td align="center" valign="top">
							<div class="Content">欢迎，欢迎，热烈欢迎！<img src="${pageContext.request.contextPath }/script/fckeditor/editor/images/smiley/wangwang/15.gif"></div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" align="center" height="28" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color="#C30000">[1楼]</font>
									2007-08-17 15:18
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img src="${pageContext.request.contextPath }/style/images/top.gif" border="0"></a>
								</li>
							</ul>
						</td>
					</tr>
				</tbody></table>
			</div><div class="ListArea demodata_record">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tbody><tr>
						<td rowspan="3" class="PhotoArea" align="center" valign="top" width="130">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif" onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';" border="0" height="110" width="110">
							</div>
							<!--作者名称-->
							<div class="AuthorName">管理员</div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href="${pageContext.request.contextPath }/BBS_Topic/saveUI.html"><img src="${pageContext.request.contextPath }/style/images/edit.gif" border="0">编辑</a>
									<a class="detail" href="#" onclick="return confirm('确定要删除本帖吗？')"><img src="${pageContext.request.contextPath }/style/images/delete.gif" border="0">删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img src="${pageContext.request.contextPath }/style/images/face/face5.gif" height="19" width="19">
									回复：新手发帖
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td align="center" valign="top">
							<div class="Content">路过...</div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" align="center" height="28" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color="#C30000">[2楼]</font>
									2007-08-17 15:18
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img src="${pageContext.request.contextPath }/style/images/top.gif" border="0"></a>
								</li>
							</ul>
						</td>
					</tr>
				</tbody></table>
			</div><div class="ListArea demodata_record">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tbody><tr>
						<td rowspan="3" class="PhotoArea" align="center" valign="top" width="130">
							<!--作者头像-->
							<div class="AuthorPhoto">
								<img src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif" onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';" border="0" height="110" width="110">
							</div>
							<!--作者名称-->
							<div class="AuthorName">管理员</div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href="${pageContext.request.contextPath }/BBS_Topic/saveUI.html"><img src="${pageContext.request.contextPath }/style/images/edit.gif" border="0">编辑</a>
									<a class="detail" href="#" onclick="return confirm('确定要删除本帖吗？')"><img src="${pageContext.request.contextPath }/style/images/delete.gif" border="0">删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img src="${pageContext.request.contextPath }/style/images/face/face3.gif" height="19" width="19">
									回复：新手发帖
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td align="center" valign="top">
							<div class="Content"><img src="${pageContext.request.contextPath }/script/fckeditor/editor/images/smiley/wangwang/11.gif"></div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" align="center" height="28" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color="#C30000">[3楼]</font>
									2007-08-17 15:18
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img src="${pageContext.request.contextPath }/style/images/top.gif" border="0"></a>
								</li>
							</ul>
						</td>
					</tr>
				</tbody></table>
			</div></div>

		<!--分页信息-->
		<div id="PageSelectorBar">
			<div id="PageSelectorMemo">
				页次：7/13页 &nbsp;
				每页显示：30条 &nbsp;
				总记录数：385条
			</div>
			<div id="PageSelectorSelectorArea">
				<!--
				<IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage2.png"/>
				-->
				<a href="javascript:void(0)" title="首页" style="cursor: hand;">
					<img src="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage.png"></a>
				
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">3</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">4</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">5</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">6</span>
				<span class="PageSelectorNum PageSelectorSelected">7</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">8</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">9</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">10</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">11</span>
				<span class="PageSelectorNum" style="cursor: hand;" onclick="gotoPageNum(2);">12</span>
				
				<!--
				<IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage2.png"/>
				-->
				<a href="#" title="尾页" style="cursor: hand;">
					<img src="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage.png"></a>
				
				转到：
				<input onfocus="this.select();" maxlength="2" class="inputStyle" value="1" name="currPage" tabindex="0" type="text">
				<input name="goBtn" value="Go" class="MiddleButtonStyle" type="submit">
			</div>
		</div>

		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tbody><tr valign="bottom">
					<td class="ForumPageTableTitleLeft" width="3">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>快速回复</b></td>
					<td class="ForumPageTableTitleRight" width="3">&nbsp;</td>
				</tr>
				<tr class="ForumPageTableTitleLine" height="1">
					<td colspan="3"></td>
				</tr>
			</tbody></table>
		</div>
	</center>
			
	<!--快速回复-->
	<div class="QuictReply">
	<form action="">
		<div style="padding-left: 3px;">
			<table class="TableStyle" border="0" cellpadding="5" cellspacing="1" width="98%">
				<tbody><tr class="Tint" height="30">
					<td class="Deep" width="50px"><b>标题</b></td>
					<td class="no_color_bg">
						<input name="title" class="InputStyle" value="回复：昨天发现在表单里删除的图片" style="width:90%" type="text">
					</td>
				</tr>
				<tr class="Tint" height="30">
					<td class="Deep" width="50px"><b>表情</b></td>
					<td class="no_color_bg"><div class="InputContent">
						<!-- 显示表情符号 -->
						<!--现在在设计单选框(radio)和复选框(checkbox)时都会给选择文字加上label增大选择范围，以提高用户体验。
							但在给单独的图片加label时无法成功。
							解决方法是：给图片img标签加上disabled即可。-->
						<table border="0" cellpadding="0" cellspacing="0">
							<tbody><tr>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="1" id="r_1" type="radio">
									<label for="r_1"><img src="${pageContext.request.contextPath }/style/images/face/face1.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="2" id="r_2" type="radio">
									<label for="r_2"><img src="${pageContext.request.contextPath }/style/images/face/face2.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="3" id="r_3" type="radio">
									<label for="r_3"><img src="${pageContext.request.contextPath }/style/images/face/face3.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="4" id="r_4" type="radio">
									<label for="r_4"><img src="${pageContext.request.contextPath }/style/images/face/face4.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="5" id="r_5" type="radio">
									<label for="r_5"><img src="${pageContext.request.contextPath }/style/images/face/face5.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="6" id="r_6" type="radio">
									<label for="r_6"><img src="${pageContext.request.contextPath }/style/images/face/face6.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="7" id="r_7" type="radio">
									<label for="r_7"><img src="${pageContext.request.contextPath }/style/images/face/face7.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="8" id="r_8" type="radio">
									<label for="r_8"><img src="${pageContext.request.contextPath }/style/images/face/face8.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="9" id="r_9" type="radio">
									<label for="r_9"><img src="${pageContext.request.contextPath }/style/images/face/face9.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="10" id="r_10" type="radio">
									<label for="r_10"><img src="${pageContext.request.contextPath }/style/images/face/face10.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="11" id="r_11" type="radio">
									<label for="r_11"><img src="${pageContext.request.contextPath }/style/images/face/face11.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="12" id="r_12" type="radio">
									<label for="r_12"><img src="${pageContext.request.contextPath }/style/images/face/face12.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="13" id="r_13" type="radio">
									<label for="r_13"><img src="${pageContext.request.contextPath }/style/images/face/face13.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
								<td style="border-bottom:0 solid #ffffff" width="50">
									<input name="faceIcon" value="14" id="r_14" type="radio">
									<label for="r_14"><img src="${pageContext.request.contextPath }/style/images/face/face14.gif" disabled="true" align="absmiddle" height="19" width="19"></label>
								</td>
							</tr>
						</tbody></table></div>
					</td>
				</tr>
				<tr class="Tint" height="200">
					<td rowspan="2" class="Deep" valign="top"><b>内容</b></td>
					<td class="no_color_bg" valign="top">
						<input id="content___Config" value="" style="display:none" type="hidden"><iframe style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; width: 90%; height: 200px;" id="content___Frame" src="${pageContext.request.contextPath }/script/fckeditor/editor/fckeditor.html?InstanceName=content&amp;Toolbar=bbs" scrolling="no" frameborder="0" height="200" width="90%"></iframe><textarea name="content" style="width: 95%; height: 300px; display: none;"></textarea>
					</td>
				</tr>
				<tr class="Tint" height="30">
					<td class="no_color_bg" colspan="2" align="center">
						<input src="${pageContext.request.contextPath }/style/blue/images/button/submit.PNG" style="margin-right:15px;" type="image">
					</td>
				</tr>
			</tbody></table>
		</div>
	</form>
	</div>
</div>

<div class="Description">
	说明：<br>
	1，主帖只在第一页显示。<br>
	2，只有是管理员才可以进行“移动”、“编辑”、“删除”、“精华”、“置顶”的操作。<br>
	3，删除主帖，就会删除所有的跟帖（回复）。<br>
</div>



<iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe></body></html>
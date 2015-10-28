<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html><head>
	<title>发表新主题</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>

	<script language="javascript" src="${pageContext.request.contextPath }/script/fckeditor/fckeditor.js" charset="utf-8"></script>
    <script type="text/javascript">
		$(function(){
			var fck = new FCKeditor("content");
			fck.Width = "99%";
			fck.Height = "100%";
			fck.ToolbarSet = "bbs";
			fck.BasePath = "${pageContext.request.contextPath }/script/fckeditor/";
			//fck.Config['SkinPath'] = "${pageContext.request.contextPath }/scriipt/fckeditoreditor/skins/office2003/";
			//fck.Config['SkinPath'] = "http://bbs.itcast.cn:80/widgets/fckeditor/editor/skins/office2003/";
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
            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" border="0" height="13" width="13"> 发表新主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
<form action="topicShow.html" style="margin: 0; padding: 0;">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1">
			<div width="85%" style="float:left">
				<font class="MenuPoint"> &gt; </font>
				<a href="${pageContext.request.contextPath }/BBS_Forum/forumList.html">论坛</a>
				<font class="MenuPoint"> &gt; </font>
				<a href="${pageContext.request.contextPath }/BBS_Forum/forumShow.html">销售常见问题</a>
				<font class="MenuPoint"> &gt;&gt; </font>
				发表新主题
			</div>
		</div>
		<div class="ItemBlockBorder">
			<table id="InputArea" border="0" cellpadding="1" cellspacing="1" width="100%">
				<tbody><tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">标题</div></td>
					<td class="InputAreaBg"><div class="InputContent">
						<input name="title" class="InputStyle" style="width:100%" type="text"></div>
					</td>
				</tr>
				<tr>
					<td class="InputAreaBg" height="30"><div class="InputTitle">表情</div></td>
					<td class="InputAreaBg"><div class="InputContent">
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
									<label for="r_8"><img src="${pageContext.request.contextPath }/style/images/face/face8.gif" disabled="true" ="true"="" align="absmiddle" height="19" width="19"></label>
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
				<tr height="240">
					<td class="InputAreaBg"><div class="InputTitle">内容</div></td>
					<td class="InputAreaBg"><div class="InputContent"><input id="content___Config" value="" style="display:none" type="hidden"><iframe style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; width: 99%; height: 100%;" id="content___Frame" src="${pageContext.request.contextPath }/script/fckeditor/editor/fckeditor.html?InstanceName=content&amp;Toolbar=bbs" scrolling="no" frameborder="0" height="100%" width="99%"></iframe><textarea style="display: none;" name="content"></textarea></div></td>
				</tr>
				<tr height="30">
					<td class="InputAreaBg" colspan="2" align="center">
						<input src="${pageContext.request.contextPath }/style/blue/images/button/submit.PNG" style="margin-right:15px;" type="image">
						<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath }/style/blue/images/button/goBack.png"></a>
					</td>
				</tr>
			</tbody></table>
		</div>
	</center>
</form>
</div>

<div class="Description">
	说明：<br>
	
</div>



<iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe><iframe scrolling="no" src="javascript:void(0)" style="margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;" frameborder="0"></iframe></body></html>
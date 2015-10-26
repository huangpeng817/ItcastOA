<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html><head>
    <title>版块列表</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img src="${pageContext.request.contextPath }/style/images/title_arrow.gif" border="0" height="13" width="13"> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table class="TableStyle" cellpadding="0" cellspacing="0">
       
        <!-- 表头-->
        <thead>
            <tr id="TableTitle" align="CENTER" valign="MIDDLE">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
		<s:iterator value="#forumList">	
        <tr class="TableDetail1 demodata_record">
				<td>${name }&nbsp;</td>
				<td>${description }&nbsp;</td>
				<td><s:a action="forumManage_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
					<s:a action="forumManage_editUI?id=%{id}">修改</s:a>
					<s:a action="forumManage_moveUp?id=%{id}">上移</s:a>
					<s:a action="forumManage_moveDown?id=%{id}">下移</s:a>
				</td>
		</tr>
		</s:iterator>
		</tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="forumManage_addUI"><img src="${pageContext.request.contextPath }/style/images/createNew.png"></s:a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br>
	1，显示的列表按其sortOrder值升序排列。<br>
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br>
</div>



</body></html>
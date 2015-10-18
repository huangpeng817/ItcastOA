<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>岗位列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script language="javascript"
	src="${pageContext.request.contextPath }/script/jquery.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/script/pageCommon.js"
	charset="utf-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath }/script/PageUtils.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="<s:url value='/style/blue/pageCommon.css'/>">
<%--     <link type="text/css" rel="stylesheet" href="<s:url value='/style/blue/pageCommon.css'/>"> --%>
<script type="text/javascript">
	
</script>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img
					src="${pageContext.request.contextPath }/style/images/title_arrow.gif"
					height="13" border="0" width="13"> 岗位管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table class="TableStyle" cellpadding="0" cellspacing="0">

			<!-- 表头-->
			<thead>
				<tr id="TableTitle" align="CENTER" valign="MIDDLE">
					<td width="200px">岗位名称</td>
					<td width="300px">岗位说明</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="roleList">
				<s:iterator value="#roleList">
					<tr class="TableDetail1 demodata_record">
						<td>${name }&nbsp;</td>
						<td>${description }&nbsp;</td>
						<td>
							<s:a onclick="return delConfirm()" action="role_delete?id=%{id}">删除</s:a>
							<s:a action="role_editUI?id=%{id}">修改</s:a> 
							<s:a action="role_setPrivilegeUI?id=%{id}">设置权限</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="role_addUI"><img
					src="${pageContext.request.contextPath }/style/images/createNew.png"></s:a>
			</div>
		</div>
	</div>


</body>
</html>
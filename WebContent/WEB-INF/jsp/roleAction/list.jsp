<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>岗位列表</title>
</head>
<body>
	岗位列表
	<br>
	<br>
	<table border="1" style="border-collapse: collapse;" width="300px">
		<thead>
			<tr>
				<th>序号</th>
				<th>岗位</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="%{roleList}">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="description" /></td>
				<td>
					<s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>&nbsp;
					<s:a action="role_editUI?id=%{id}">修改</s:a>
				
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	<s:a action="role_addUI">添加</s:a>
</body>
</html>
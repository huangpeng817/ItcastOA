<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
<s:form action="role_edit">
	<s:hidden name="id"></s:hidden>
	岗位：<s:textfield name="name"></s:textfield><br>
	描述：<s:textfield name="description"></s:textfield><br>
	<s:submit value="修改"></s:submit>
</s:form>
</body>
</html>
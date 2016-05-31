<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
	<s:form action='alterEntity_user.action?id=<s:property value="userId" />' method="post" theme="simple">
		用户名：<s:property value="#session.username"/><br />
		密码：<s:textfield name="bbsuser.password"></s:textfield><br />
		确认密码：<s:textfield name="password2"></s:textfield><br />
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>
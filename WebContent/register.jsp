<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<s:form action="register" method="post" theme="simple">
		<table>
			<tr>
				<td>用户名：</td>
				<td><s:textfield name="user.username"></s:textfield></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><s:textfield name="user.password"></s:textfield></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><s:textfield name="password2"></s:textfield> </td>
			</tr>
			<tr>
				<td></td>
				<td><s:subset ></s:subset> </td>
				<td><s:submit value="确定"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
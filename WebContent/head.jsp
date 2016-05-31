<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<style type="text/css">
	#login{
		float:right;
		border:1px solid blue;
	}
	#body{
		width:1000px;
		margin:auto;
		height:100px;
	}
	#message{
		display:none;
	}
	</style>
	<script type="text/javascript" src="jquery-2.0.0.min.js"></script>
	<script type="text/javascript">		
	</script>
</head>
</head>
<body>
	<div id="body">
		<div id="login">
			<div>
				<s:if test="#session.user.username != null">
					你好！<s:property value="#session.user.username"/>
					<script type="text/javascript">
						var login = document.getElementById('loginDiv');
						login.style.display = 'none';
					</script>
				</s:if>
			</div>
			<div id="loginDiv">
				<s:else>
					<form action="login" method="post" theme="simple">
						<table>
							<tr>
								<td>用户名：</td>
								<td><s:textfield id="userName" name="user.username"></s:textfield></td>
								<td id="message" color="red"></td>
								<td></td>
							</tr>
							<tr>
								<td>密码：</td>
								<td>
								<%-- <s:textfield  id="userPassword" name="user.password"></s:textfield> --%>
								<input type="text" name="user.password"/>
								</td>
								<td><s:submit id="submit" value="登录"></s:submit> </td>
								<td><a href="toRegister.action">注册</a></td>
							</tr>
						</table>
					</form>
				</s:else>
			</div>	
		</div>
		<%
		java.util.Date now=new java.util.Date();
		out.println(now);
		%>
	</div>
</body>

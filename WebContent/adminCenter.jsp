<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员中心</title>
<script type="text/javascript">
function del(){
	var flag = false;
	if(confirm("确定要删除吗？")){
		flag = true;
		}
	return flag;
}
</script>
</head>
<body>
	这是管理员中心
	<div>
		<s:form method="post" theme="simple">
			<ul>
				<li><a href="pageUserManage.action">用户管理</a></li>
				<li><a href="pageTipManage.action">帖子管理</a></li>
			</ul>
		</s:form> 
	</div>
	<s:if test='pageArg == "用户管理"'>
		<h1>这个是用户管理</h1>
		<div>
			<s:iterator value="allUsers" status="st">
			<s:property value="username"/>&nbsp
			<s:property value="password"/>&nbsp
			<a href="toAlterUserPage.action?id=<s:property value="userId" />&amp">修改</a>&nbsp
			<a href="deleteEntity_user.action?id=<s:property value="userId"/>" onclick="del()">删除</a>
			<br />
			</s:iterator>
		</div>
		<div>
			<!-- 定义pageNumber值为1的URL值，以及【首页】链接 -->
			<s:property value="pageNumber"/>|<s:property value="totalPage"/>
			<s:url id="firstPage" action='page_userManage'>
				<s:param name='pageNumber'>1</s:param>
			</s:url>
			<s:a href="%{firstPage}">首页</s:a>
			<s:url id="prePage" action='page_userManage'>
				<s:param name="pageNumber">
					<s:property value="pageNumber-1"/>
				</s:param>
			</s:url>
			<s:a href="%{prePage}">上一页</s:a>
			<s:url id="nextPage" action='page_userManage'>
				<s:param name="pageNumber">
					<s:property value="pageNumber+1"/>
				</s:param>
			</s:url>
			<s:a href="%{nextPage}">下一页</s:a>
			
			<s:url id="lastPage" action='page_userManage'>
				<s:param name="pageNumber">
					<s:property value="totalPage"/>
				</s:param>
			</s:url>
			<s:a href="%{lastPage}">末页</s:a>
		</div>
	</s:if>
	<s:elseif test='pageArg == "帖子管理"'>
		<h1>这个是帖子管理</h1>
		<div>
			<s:iterator value="allTips" status="st">
				<s:property value="title"/>&nbsp;
				<s:property value="content"/>&nbsp;
				<s:property value="publishtime"/>&nbsp;
				<s:property value="realfile"/>&nbsp;
				<s:property value="makefile"/>&nbsp;
				<s:property value="user.username"/>&nbsp;
				<s:property value="board.boardname "/>&nbsp;
				<a href="deleteEntity_tip.action?id=<s:property value="tipId"/>" onclick="del()">删除</a>
				<br />
			</s:iterator>
		</div>
		<div>
			<!-- 定义pageNumber值为1的URL值，以及【首页】链接 -->
			<s:property value="pageNumber"/>|<s:property value="totalPage"/>
			<s:url id="firstPage" action='page_tipManage'>
				<s:param name='pageNumber'>1</s:param>
			</s:url>
			<s:a href="%{firstPage}">首页</s:a>
			<s:url id="prePage" action='page_tipManage'>
				<s:param name="pageNumber">
					<s:property value="pageNumber-1"/>
				</s:param>
			</s:url>
			<s:a href="%{prePage}">上一页</s:a>
			<s:url id="nextPage" action='page_tipManage'>
				<s:param name="pageNumber">
					<s:property value="pageNumber+1"/>
				</s:param>
			</s:url>
			<s:a href="%{nextPage}">下一页</s:a>
			
			<s:url id="lastPage" action='page_tipManage'>
				<s:param name="pageNumber">
					<s:property value="totalPage"/>
				</s:param>
			</s:url>
			<s:a href="%{lastPage}">末页</s:a>
		</div>
	</s:elseif>  
</body>
</html>
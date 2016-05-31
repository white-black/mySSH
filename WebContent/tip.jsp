<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子页</title>
<link  rel="stylesheet" type="text/css" href="css/tip.css"  />
<script type="text/javascript">
	function sub(){
		var flag = false;
		if(confirm("确认提交？")){
			flag = true;
			}
		return flag;
	}
</script>
</head>
<body>
	<%@ include file="head.jsp" %>
	<div id="body">
		<div id="location"><span>当前所在的位置：</span><s:property value="#session.board.boardname"/></div>
		<div id="display">
			<table>
				<s:iterator value="boardTips" status="st">
					<tr>
						<td class="t1"><a href="tipToReply?tipId=<s:property value='tipId'/>">
							<s:property value="title"/></a>
						</td>
						<td class="t2"><s:property value="user.username"/></td>
						<td class="t3"><s:property value="publishtime"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div id="link">
			<!-- 定义pageNumber值为1的URL值，以及【首页】链接 -->
			<s:property value="pageNumber"/>|<s:property value="totalPage"/>
			<s:url id="firstPage" action='index_Tip'>
				<s:param name='pageNumber'>1</s:param>
			</s:url>
			<s:a href="%{firstPage}">首页</s:a>
			<s:url id="prePage" action='index_Tip'>
				<s:param name="pageNumber">
					<s:property value="pageNumber-1"/>
				</s:param>
			</s:url>
			<s:a href="%{prePage}">上一页</s:a>
			<s:url id="nextPage" action='index_Tip'>
				<s:param name="pageNumber">
					<s:property value="pageNumber+1"/>
				</s:param>
			</s:url>
			<s:a href="%{nextPage}">下一页</s:a>
			
			<s:url id="lastPage" action='index_Tip'>
				<s:param name="pageNumber">
					<s:property value="totalPage"/>
				</s:param>
			</s:url>
			<s:a href="%{lastPage}">末页</s:a>
		</div>
		<div id="publish">
			<s:form action="addTip" method="post" theme="simple">
				主题：<s:textfield name="tip.title"></s:textfield><br />
				内容：<s:textarea name="tip.content" rows="10" cols="30"></s:textarea><br />
				<s:submit value="提交" onclick="sub()"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>
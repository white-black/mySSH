<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<link rel="stylesheet" type="text/css" href="css/index.css"  />
	<script type="text/javascript" type="text/javascript">
	</script>
</head>
<body>
	<%@ include file="head.jsp" %>
	<div id="body">
		<div><a href="getEntity_board">点击浏览</a></div>
		<div id="display">
			<ul>
				<s:iterator value="allBoards" status="st">
					<li><a href="indexToTip?boardId=<s:property value='boardId' />">
					<span><s:property value="boardname"/></span></a>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>
</body>
</html>
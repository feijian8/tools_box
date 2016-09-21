<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.0.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<a target="_blank" href="${centerurl}/demo/index.htm">返回首页</a>
<h2>当前用户</h2>
<table id="contentTable9"
	class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td><b>uid : </b>${user.uid}</td>
			<td><b>姓名 : </b>${user.name}</td>
			<td><b>性别 : </b> <c:if test="${user.gender==1}">男</c:if> <c:if
				test="${user.gender==0}">女</c:if></td>
			<td><b>头像 : </b><img width="60" src="${imgcdn}/${user.leave}" /></td>
		</tr>
	</thead>
</table>

<h2>发送消息</h2>
${tag}
<form action="${centerurl}/demo/chathislist.htm"><input
	name="uid" value="${uid}" type="hidden" /> <input name="formUid"
	value="${formUid}" type="hidden" /> <textarea rows="10" cols="140"
	name="ct"></textarea> <br />
<button type="submit">发送</button>
<button type="button"
	onclick="location.href='${centerurl}/demo/chathislist.htm?uid=${uid}&formUid=${formUid}'">刷新列表</button>
</form>

<h2>消息历史， 按时间降序 最近 300 条</h2>

<table id="contentTable10"
	class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td><b>对方uid</b></td>
			<td><b>用户名称</b></td>
			<td><b>性别</b></td>
			<td><b>头像</b></td>
			<td><b>是否在线</b></td>
			<td><b>消息时间</b></td>
			<td><b>消息类型</b></td>
			<td><b>消息方向</b></td>
			<td><b>消息内容</b></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="item">
			<tr>
				<td><b>${item.scu}</b></td>
				<td><b>${item.suser.name}</b></td>
				<td><b> <c:if test="${item.suser.gender==1}">男</c:if> <c:if
					test="${item.suser.gender==0}">女</c:if> </b></td>
				<td><c:if test="${not empty item.suser.leave}">
					<img width="60" src="${imgcdn}/${item.suser.leave}" />
				</c:if> <c:if test="${empty item.suser.leave}">
						没有头像
					</c:if></td>
				<td><c:if test="${item.suser.isconn==1}">
					<font color="green">在线</font>
				</c:if> <c:if test="${item.suser.isconn==0}">
					<font color="red">离线</font>
				</c:if></td>
				<td><b>${item.createDateStr}</b></td>
				<td><b> <c:if test="${item.tp==1}">文字</c:if> <c:if
					test="${item.tp==2}">
					<font color="blue">图片</font>
				</c:if> </b></td>
				<td><b> <c:if test="${item.dt==2}">
					<font color="green">发送 ---></font>
				</c:if> <c:if test="${item.dt==1}">
					<font color="red"><---接收</font>
				</c:if> </b></td>
				<td><c:if test="${item.tp==1}">
					${item.ct}
				</c:if> <c:if test="${item.tp==2}">

					<img width="160" src="${imgcdn}/${item.picl}" />
				</c:if></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
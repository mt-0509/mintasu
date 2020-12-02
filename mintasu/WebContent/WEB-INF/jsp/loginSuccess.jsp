<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBeans" %>
<%
UserBeans user = (UserBeans) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ログイン成功！！！</h1>
<p>ようこそ<%= user.getName() %>さん</p>
<a href="mintasu">投稿画面にいく</a>
</body>
</html>
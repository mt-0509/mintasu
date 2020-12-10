<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんタス</title>
</head>
<body>
<h1>投稿画面</h1>
<p>みんなで今日行うタスクを投稿していこう！！</p>
<form action="/mintasu/CO_Post" method="post">
<p>コメント<br>
<textarea name="comment" rows="5" cols="40"></textarea>
</p>
<p><input type="submit" value="送信"></p>


</form>




<c:forEach var="list" items="${listAttribute}">
<p>　<%-- 名前:<c:out value="${list.name}"/>　<br> --%>
<c:out value="${list.comment}"/></p>
</c:forEach>



<a href="/mintasu/index.jsp">トップに戻る</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board One</title>
</head>
<body>
	${data}
	<h1>${data.result.title}</h1>
	<p>${data.result.content}</p>
	<a href="/test/view/board/updateView?boardNo=${data.result.boardNo}">수정</a>
	<a href="/test/view/board/delete?boardNo=${data.result.boardNo}">삭제</a>
	<a href="/test/view/board/selectList">돌아가기</a>
</body>
</html>
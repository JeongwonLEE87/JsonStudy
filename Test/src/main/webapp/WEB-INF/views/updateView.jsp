<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 화면</title>
</head>
<body>
	${data}
	<form action="/test/view/board/update">
		<input type="text" name="title" placeholder="제목" value="${data.result.title}"><br>
		<input type="text" name="content" placeholder="내용" value="${data.result.content}"><br>
		<input type="hidden" name="boardNo" value="${data.result.boardNo}"><br>
		<input type="submit" value="수정">
		<a href="/test/view/board/selectList">돌아가기</a>
	</form>
</body>
</html>
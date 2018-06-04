<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json - Board One</title>

<script type="text/javascript" src="/test/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
</head>
<body>
	<h1 id="title"></h1>
	<p id="content"></p>
	
<script>
	$(document).ready(function(){
		console.log('${QueryString}');
		console.log('${QueryString.boardNo}');
		
		var boardNo = '${QueryString.boardNo}';
		
		$.ajax({
			url: "/test/json/board/selectOne",
			data: {"boardNo": boardNo}
		})
		.done(function(data) {
			  var d = JSON.parse(data)
			  var dd = d.result;
			  console.log(dd);
			  $("#title").text(dd.title);
			  $("#content").text(dd.content);
		});
	});
</script>
</body>
</html>
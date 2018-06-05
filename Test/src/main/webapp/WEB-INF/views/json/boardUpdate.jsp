<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board One</title>
	<script type="text/javascript" src="/test/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
	<script type="text/javascript" src="/test/resources/js/common.js"></script>
	<script>
		$(document).ready(function(){
			var boardNo = '${QueryString.boardNo}';
			var data = {"boardNo" : boardNo};
			
			$.ajax({
				url : "/test/json/board/selectOne",
				data : data
			}).done(function(data) {
				  var d = JSON.parse(data)
				  var dd = d.result;
				  console.log(dd);
				  $("#title").val(dd.title);
				  $("#content").val(dd.content);
				  $("#regUser").val(dd.regUser);
			});
			
			$("#delete").on("click", function(){
				console.log("delete 선택!");
				$.ajax({
					url : "/test/json/board/delete",
					data : data
				}).done(function(data) {
					i_d(data);
				});
				
			});
			
			$("form").submit(function(event){
				event.preventDefault();
				console.log("form submit!");
				
				var title = $("#title").val();
				var content = $("#content").val();
				var regUser = $("#regUser").val();
				var boardNo = '${QueryString.boardNo}';
				
//			 	console.log(title, content, regUser);
				
				/* ================================ */
				if(title == ""){
					alert("제목을 입력하세요.");
					return false;
				}
				
				if(content == ""){
					alert("내용을 입력하세요.");
					return false;
				}
				
				/* ================================ */
				
				var d = {
					"title":title,
					"content":content,
					"regUser":regUser,
					"boardNo":boardNo
				};
				
				$.ajax({
					url: "/test/json/board/update",
					data: d, 
				}).done(function(data){
					console.log(data);
					var jsonData = JSON.parse(data);
					if(jsonData.result == 1){
						alert("성공!");
						location.href = "/test/board/selectOne?boardNo="+boardNo;
					}else{
						alert("실패!");
					}
				});
			});
			
		});
	</script>
</head>
<body>
	<form>
		<input type="text" id="title" value="">
		<input type="text" id="content" value=""><br>
		<select name="regUser" id="regUser">
			<option value="1">관리자</option>
			<option value="2">구디</option>
			<option value="3">김경빈</option>
		</select>
		<input type="submit" value="저장"/>
		<a href="/test/board/selectOne?boardNo=${QueryString.boardNo}">돌아가기</a>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<script src="/resources/js/hhwboard.js"></script>
<title>글쓰기</title>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	});
</script>
</head>
<body>

<div style="width: 80%;">
	<form method="post" action="/write">
		<select name="ctgory">
		    <option value="">카테고리</option>
		    <option value="공지">공지</option>
		    <option value="질문">질문</option>
		    <option value="정보">정보</option>
		    <option value="자유게시판">자유게시판</option>
		    <option value="기타">기타</option>
		</select>
		<input type="text" name="writer" style="width: 20%;" placeholder="작성자"/><br>
		<input type="text" name="title" style="width: 40%;" placeholder="제목"/>
		<br><br> 
		<textarea id="summernote" name="content" style="text-align: center;"></textarea>
		<input id="subBtn" type="reset" value="취소" style="float: right;" onclick="window.close()"/>
		<input id="subBtn" type="button" value="글 작성" style="float: right;" onclick="goWrite(this.form)"/>
	</form>
</div>

</body>
</html>
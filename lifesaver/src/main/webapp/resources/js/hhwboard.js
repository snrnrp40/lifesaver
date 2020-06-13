function goWrite(frm) {
	var title = frm.title.value;
	var writer = frm.writer.value;
	var content = frm.content.value;
	var category = frm.category.value;
	
	if (category.trim() == '') {
		alert("카테고리를 선택하세요");
		return false;
	}
	if (title.trim() == ''){
		alert("제목을 입력해주세요");
		return false;
	}
	if (writer.trim() == ''){
		alert("작성자를 입력해주세요");
		return false;
	}
	if (content.trim() == ''){
		alert("내용을 입력해주세요");
		return false;
	}
	
	
	frm.submit();
	alert("게시글작성완료");
	window.close();
}
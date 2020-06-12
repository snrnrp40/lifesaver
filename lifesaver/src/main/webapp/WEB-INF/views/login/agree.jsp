<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

html, body {
	color: #454545;
	font-family: Noto Sans CJK JP;
	font-weight: bold;
}

img {
	max-width: 100%;
	max-height: auto;
}

#container {
	width: 90%;
	margin: 0 auto;
	text-align: center;
	/* border: 1px solid black; */
}

#header {
	padding: 20px;
	margin-bottom: 20px;
	/* border: 1px solid green; */
}

#frame {
	margin-top: -44px;
	display: inline-block;
	width: 35%;
	padding-top: 120px;
	clear: both;
/* 	border: 1px solid red;  */
	background-color: rgb(249, 249, 249);
}

#context{
	margin-bottom: 20px;
	color: red;
}

#agreeall{
	display: inline-block;
	vertical-align: 6px;
	padding-bottom: 0px;
}

#checking{
	width: 100%;
	margin: 0 auto;
	float: left;
	text-align: left;
	margin-top: -15px;
	/* border: 1px solid green; */
}

#agree1, #agree2, #agree3 {
	width: 90%;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 10px;
}

#agreebutton{
	float: right;
	height: 70%;
}



#other{
	width: 90%;
	margin: 0 auto;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	/* border: 1px solid red; */
	text-align: left;
}

#button{
	margin-top: 50px;
	margin-bottom: 43px;
}

#beforebutton, #afterbutton {
	margin-right: 10px;
}


#logo2 {
	margin-bottom: -10px;
} 

#footer {
	margin-top: -10px;
}



@media(max-width: 480px) {
	#container{
	width: auto;
	}
	#header{
	width: auto;
	}
	#frame{
	width: auto;
	}
	#context{
	width: auto;
	}
	#agree{
	width: auto;
	}
	#footer{
	width: auto;
	}
	img{
	width: auto;
	}
	#logo2{
	width: 20%;
	height: 20%;
	margin-bottom: -5px;
	}
	#step{
	width: auto;
	}
}
</style>

<script type="text/javascript">

function changeImg() {
	var on = document.getElementById('on');

	if(on.src.indexOf('off') == -1) {
	on.src = on.src.replace('on.png', 'off.png');
	
	// 로그인 유지 : 세션에 저장 
	
	
	} else {
	on.src = on.src.replace('off.png', 'on.png');
	
	// 로그인 유지 해제 : 세션에서 삭제
	
	}
}

function changeImg2() {
	var on = document.getElementById('on2');

	if(on.src.indexOf('off') == -1) {
	on.src = on.src.replace('on.png', 'off.png');
	
	// 로그인 유지 : 세션에 저장 
	
	
	} else {
	on.src = on.src.replace('off.png', 'on.png');
	
	// 로그인 유지 해제 : 세션에서 삭제
	
	}
}


</script>


</head>
<body>



<div id="container">

	<div id="header">
		<img src="<c:url value="/resources/img/agree/logo.png"/>" alt="로고" id="logo" />	 <br />
		<span id="step">Step.1 약관동의&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Step.2 회원정보입력&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Step.3 가입완료</span>
		<br />
		
		<img src="<c:url value="/resources/img/agree/actionLine.png"/>" alt="" />
		
	</div>


	<div id="frame">
	
		<div id="context">
			온라인채널(홈페이지/모바일웹) <br />
			회원가입을 위한 이용 약관 동의, <br />
			개인정보 수집 및 이용 동의	 <br />
			<br />
			<br />
			
		</div>
			
		<div id="checking">
	
		
			<hr />
				
				<div id="agree1">
				<img src=" <c:url value="/resources/img/agree/off.png"/>" alt="" onclick="changeImg()" id="on"/> 
				<span id="agreeall">전체동의</span>
				
				</div>
			<hr />

				<div id="agree2">
				<img src=" <c:url value="/resources/img/agree/off.png"/>" alt="" onclick="changeImg2()" id="on2"/> 
				<span id="agreeall">이용약관 동의 (필수)</span>
				 
				<img src="<c:url value="/resources/img/agree/agreebefore.png"/>" alt="" id="agreebutton"/>
				
				</div>
				
				<div id="agree3">
				<img src="<c:url value="/resources/img/agree/checkedDefault.png"/>" alt="" />
				<span id="agreeall">개인정보 수집 및 이용동의 (필수)</span> 
				
				<img src="<c:url value="/resources/img/agree/agreebefore.png"/>" alt="" id="agreebutton"/>
				
				</div>
			
		</div>
		<hr />
		<div id="other">	
			<span style="font-size:16px">기타 안내 사항</span>
			<img src="<c:url value="/resources/img/agree/agreebefore.png"/>" id="agreebutton1" />
			<br />
			<span style="font-size:12px">위의 개인정보 수집/이용에 대한 동의를 거부할 권리가 있습니다.</span>
		</div>	
	
		<div id="button">
		
		
			<a href="<c:url value="/main" />"><img src="	<c:url value="/resources/img/agree/beforeBtnDefault.png"/>" id="beforebutton2" /></a>
				
			<a href="<c:url value="/registerSelect" />"><img src="<c:url value="/resources/img/agree/nextBtnClick.png"/>" id="nextbutton" /></a>	
		</div>
		
		
	</div>
			

		<div id="agree">
			<br />
			<br />
			이용약관 | 개인정보처리방침 | 책임의 한계와 법적 고지 | 회원정보 고객센터
			<br />
			<br />
		</div>
			
		<div id="footer">
				
			<img src="<c:url value="/resources/img/login/logo2.png"/>" id="logo2" />
			Copyright  LifeSaver Corp.  All Right Reserved.
			
			</div>
		
</div>
 
</body>
</html>
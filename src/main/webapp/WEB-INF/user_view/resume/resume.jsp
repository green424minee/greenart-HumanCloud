<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MyPage | Resume</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header>
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
		</ul>
	</header>
	<div>
		<h2>${ login.name }님의 이력서</h2>
		<h1>${ resume.title }</h1>
	</div>
	<div class="education">
		<p>
		${ education.school_type }
		<br>
		${ education.school_name } | ${ education.status }
		</p>
	</div>
	<div class="experience">
		${ experience }
	</div>
	<div class="licenses">
		${ licenses }
	</div>
	<div>
		<a href="">이력서 수정</a>
		<a href="">이력서 삭제</a>
	</div>
</body>
</html>
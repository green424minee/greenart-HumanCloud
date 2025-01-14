<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${ recruitment.title }</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header>
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
		</ul>
	</header>
	<div>
		<h2>${ corp.name }</h2><br>
		<h1>${ recruitment.title }</h1>
		<button>즐겨찾기</button>
		<a href="">지원하기</a>
	</div>
	<div>
		<small>등록일 : ${ recruitment.created_at }
		<br>수정일 : ${ recruitment.updated_at }</small>
	</div>
	<div>
		${ recruitment.description }
	</div>
</body>
</html>
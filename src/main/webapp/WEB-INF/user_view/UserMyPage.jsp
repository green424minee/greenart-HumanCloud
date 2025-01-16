<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Human Cloud | MyPage</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
</head>
<body>
<div class="container"	>
	<header class="breadcrumb">
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
		</ul>
	</header>
	<div class="columns">
		<div class="column is-one-fifth">
			<aside class="navbar-start">
				<nav>
					<ul>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage">마이페이지</a></li>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume">이력서</a></li>
						<li><a href="">즐겨찾기</a></li>
						<li><a href="">지원내역</a></li>
						<li><a href="">받은제안</a></li>
					</ul>
				</nav>
			</aside>
		</div>
		<div class="column">
		<h1>마이페이지</h1>
		<h2>${ login.getName() } 님</h2>
			<nav>
				<ul>
					<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/update">회원 정보 관리</a></li>
					<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume">이력서 관리</a></li>
					<li><a href="">즐겨찾기</a></li>
					<li><a href="">지원내역</a></li>
					<li><a href="">받은제안</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
</body>
</html>
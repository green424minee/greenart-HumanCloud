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
<div class="container is-max-desktop">
	<header class="section">
		<a href="${pageContext.request.contextPath}">HumanCloud</a>
	</header>
	<div class="columns">
		<div class="column is-one-fifth">
			<aside class="navbar-start">
				<nav>
					<ul>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage">마이페이지</a></li>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume">이력서</a></li>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/scrapList">즐겨찾기</a></li>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/apply">지원내역</a></li>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/ReceivedOffer">받은제안</a></li>
					</ul>
				</nav>
			</aside>
		</div>
		<div class="column">
			<h1>회원 정보 관리</h1>
			<strong>${ login.getName() } 님</strong>
			<form class="field" method="post">
			 	<label class="label" for="currentPassword">현재 비밀번호</label>
				<input class="input" type="password" name="currentPassword" id="currentPassword">
				<label class="label" for="newPassword">변경할 비밀번호</label>
				<input class="input" type="Password" name="newPassword" id="newPassword">
				<label class="label" for="newPassword">변경할 비밀번호 확인</label>
				<input class="input" type="Password" name="newPasswordCheck" id="newPasswordCheck">
				<label class="label" for="phone">전화번호</label>
				<input class="input" type="text" name="phone" id="phone" value="${ login.getPhone() }">
				<label class="label" for="email">이메일</label>
				<input class="input" type="text" name="email" id="email" value="${ login.getEmail() }">
				<label class="label" for="address">주소</label>
				<input class="input" type="text" name="address" id="address" value="${ login.getAddress() }">
				<input class="button is-link" type="submit" value="변경하기">
			</form>
		</div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Human Cloud | MyPage</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header>
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
		</ul>
	</header>
	<aside>
		<nav>
			<ul>
				<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage">마이페이지</a></li>
				<li><a href="">이력서</a></li>
				<li><a href="">즐겨찾기</a></li>
				<li><a href="">지원내역</a></li>
				<li><a href="">받은제안</a></li>
			</ul>
		</nav>
	</aside>
	<div>
		<h1>회원 정보 관리</h1>
		<h2>${ login.getName() } 님</h2>
		<form method="post">
		 	<label for="currentPassword">현재 비밀번호</label>
			<input type="password" name="currentPassword" id="currentPassword">
			<label for="newPassword">변경할 비밀번호</label>
			<input type="Password" name="newPassword" id="newPassword">
			<label for="newPassword">변경할 비밀번호 확인</label>
			<input type="Password" name="newPasswordCheck" id="newPasswordCheck">
			<label for="phone">전화번호</label>
			<input type="text" name="phone" id="phone" value="${ login.getPhone() }">
			<label for="email">이메일</label>
			<input type="text" name="email" id="email" value="${ login.getEmail() }">
			<label for="address">주소</label>
			<input type="text" name="address" id="address" value="${ login.getAddress() }">
			<input type="submit" value="변경하기">
		</form>
	</div>
</body>
</html>
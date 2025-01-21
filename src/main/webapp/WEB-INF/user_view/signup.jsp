<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>SIGN UP</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
</head>
<body>
<div class="container is-max-desktop">
	<header class="section navbar">
		<div class="navbar-start">
			<div class="navber-item">
				<a href="${pageContext.request.contextPath}">HumanCloud</a>
			</div>
		</div>
	</header>
	<div>
		<form class="field" method="post">
			<label class="label" for="name">이름</label>
			<input class="input" type="text" name="name" id="name" required="required">
			<label class="label" for="userName">아이디</label>
			<input class="input" type="text" name="userName" id="userName" maxlength="20" placeholder="최대 20글자" required="required">
			<label class="label" for="password">비밀번호</label>
			<input class="input" type="password" name="password" id="password" maxlength="20" placeholder="최대 20글자" required="required">
			<label class="label" for="passwordCheck">비밀번호</label>
			<input class="input" type="password" name="passwordCheck" id="passwordCheck" maxlength="20" placeholder="최대 20글자" required="required">
			<label class="label" for="phone">전화번호</label>
			<input class="input" type="text" name="phone" id="phone" placeholder="010-0000-0000" required="required">
			<label class="label" for="email">이메일</label>
			<input class="input" type="text" name="email" id="email" placeholder="email@java.com" required="required">
			<input class="button is-link" type="submit" value="회원가입 확인">
		</form>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SIGN UP</title>
</head>
<body>
	<header>
	
	</header>
	<div>
		<form method="post">
			<label for="name">이름</label>
			<input type="text" name="name" id="name" required="required">
			<label for="userid">아이디</label>
			<input type="text" name="userid" id="userid" maxlength="20" placeholder="최대 20글자" required="required">
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" maxlength="20" placeholder="최대 20글자" required="required">
			<label for="passwordCheck">비밀번호</label>
			<input type="password" name="passwordCheck" id="passwordCheck" maxlength="20" placeholder="최대 20글자" required="required">
			<label for="phone">전화번호</label>
			<input type="text" name="phone" id="phone" placeholder="010-0000-0000" required="required">
			<label for="email">이메일</label>
			<input type="text" name="email" id="email" placeholder="email@java.com" required="required">
			<input type="submit" value="회원가입 확인">
		</form>
	</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>SIGN IN</title>
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
		<div class="navbar-end">
			<div class="navbar-item">
				<a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업 홈</a>
			</div>
		</div>
	</header>
	<div >
		<form class="field" method="post">
			<label class="label" for="userName">아이디</label>
			<div class="control">
			<input class="input" type="text" name="userName" required="required">
			</div>
			<label class="label" for="password">비밀번호</label>
			<div class="control">
			<input class="input" type="password" name="password" required="required">
			</div>
			<c:if test="${ message != null }">
				${ message }
			</c:if>
			<input class="button is-link" type="submit" value="Sign in">
		</form>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/HumanCloud/user/Signup">회원가입하기</a>
	</div>
</div>
</body>
<script>
	const form = document.getElementById("sign-form");

	const useridInput = document.getElementById("userName");
	const passwordInput = document.getElementById("password");

	useridInput.addEventListener("input", validateUserid);
	passwordInput.addEventListener("input", validatePassword);

	form.addEventListener("submit", submitForm);

	function validateUserid() {
		const userid = useridInput.value.trim();

		if (userid === "") {
			useridInput.setCustomValidity("userid is required");
		} else if (userid.length < 2) {
			useridInput.setCustomValidity("userid must be at least 2 characters");
		} else if (userid.length > 30) {
			useridInput.setCustomValidity("userid must be less than 30 characters");
		} else {
			useridInput.setCustomValidity("");
		}
	}

	function validatePassword() {
		const password = passwordInput.value.trim();

		if (password === "") {
			passwordInput.setCustomValidity("Password is required");
		} else if (password.length < 6) {
			passwordInput.setCustomValidity("Password must be at least 6 characters");
		} else if (password.length > 20) {
			passwordInput.setCustomValidity("Password must be less than 20 characters");
		} else {
			passwordInput.setCustomValidity("");
		}
	}

	function submitForm(event) {
		event.preventDefault();
		
		validateUserid();
		validatePassword();

		if (form.checkValidity()) {
			form.submit();
		} else {
			form.reportValidity();
			alert("입력값 확인 필요!!");
		}
	}
</script>
</html>
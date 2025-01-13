<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SIGN IN</title>
</head>
<body>
	<header>
		<ul>
			<li><a href="/_greenart_HumanCloud">HumanCloud</a></li>
			<li><a href="">기업 홈</a></li>
		</ul>
	</header>
	<div>
		<form method="post">
			<input type="text" name="userName" required="required">
			<input type="password" name="password" required="required">
			<c:if test="${ message != null }">
				${ message }
			</c:if>
			<input type="submit" value="Sign in">
		</form>
	</div>
	<div>
		<a href="/_greenart_HumanCloud/HumanCloud/user/Signup">회원가입하기</a>
	</div>
</body>
</html>
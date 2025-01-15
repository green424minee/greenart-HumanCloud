<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<a href="">이력서 작성하기</a>
	</div>
	<div>
		<ul class="">
			<c:forEach var="myResume" items="${list}">
				<li>
					<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my?id=${myResume.id}">${myResume.title}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
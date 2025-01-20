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
	<aside>
		<nav>
			<ul>
				<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage">마이페이지</a></li>
				<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume">이력서</a></li>
				<li><a href="">즐겨찾기</a></li>
				<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/apply">지원내역</a></li>
				<li><a href="">받은제안</a></li>
			</ul>
		</nav>
	</aside>
	<div>
		<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/create">이력서 작성하기</a>
	</div>
	<div>
		<ul class="">
			<c:forEach var="myResume" items="${list}">
				<li>
					<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my?id=${myResume.id}">${myResume.title}</a>
					<c:choose>
					<c:when test="${ myResume.id == crrentUser.default_resume_id }">
						대표 이력서
					</c:when>
					<c:otherwise>
					<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my/setDefault?id=${myResume.id}">대표로 설정하기</a>
					</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MyPage | Resume</title>
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
			<div class="section">
				<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/create">이력서 작성하기</a>
			</div>
			<div class="section">
				<ul class="content">
					<c:forEach var="myResume" items="${list}">
						<li class="columns">
						<div class="column">
							<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my?id=${myResume.id}">${myResume.title}</a>
						</div>
						<div class="column">
							<c:choose>
							<c:when test="${ myResume.id == crrentUser.default_resume_id }">
								대표 이력서
							</c:when>
							<c:otherwise>
							<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my/setDefault?id=${myResume.id}">대표로 설정하기</a>
							</c:otherwise>
							</c:choose>
						</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Human Cloud | HOME</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
</head>
<body>
<div class="container is-max-desktop">
	<header class="section navbar">
		<div class="navbar-start">
			<div class="navbar-item">
			<a href="${pageContext.request.contextPath}">HumanCloud</a>
			</div>
		</div>
		<div class="navbar-item">
			<form action="${pageContext.request.contextPath}/HumanCloud/RecruitmentList" method="post">
			<div class="field has-addons">
				<div class="control">
					<input class="input" type="text" name="keyword" placeholder="키워드로 검색하기">
				</div>
				<div class="control">
					<input type="submit" class="button is-info">
				</div>
			</div>
			</form>
		</div>
		<div class="navbar-end">
		<div class="navbar-item">
			<a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업서비스</a>
		</div>
		</div>
	</header>
	<div>
		<nav class="navbar">
		<div class="navbar-menu">
			<div class="navbar-start">
			<div class="navbar-item">
				<a href="${pageContext.request.contextPath}/HumanCloud/RecruitmentList">전체 채용 리스트</a>
			</div>
			<div class="navbar-item">
				<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume">이력서 관리</a>
			</div>
			<div class="navbar-item">
				<a href="${pageContext.request.contextPath}/HumanCloud/user/scrapList">즐겨찾기</a>
			</div>
			</div>
		</div>
			<div class="navbar-end">
			<c:choose>
			<c:when test="${ login != null }">
				<div class="navbar-item">
					환영합니다. ${ login.getName() } 님
					<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage">마이페이지</a>
					<a href="${pageContext.request.contextPath}/HumanCloud/user/Signout">로그아웃</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="navbar-item">
					<a href="${pageContext.request.contextPath}/HumanCloud/user/Signin">로그인</a>
				</div>
			</c:otherwise>
			</c:choose>
			</div>
		</nav>
	</div>
	<div class="section">
	<div class="fixed-grid has-3-cols">
		<ul class="grid">
			<c:forEach var="recruitment_list" items="${ list }" begin="0" end="11">
				<li class="cell">
					<a href="${pageContext.request.contextPath}/HumanCloud/Recruitment?recruitment_id=${recruitment_list.id}">${ recruitment_list.name }<br>
						<strong>${ recruitment_list.title }</strong>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	</div>
</div>
</body>
</html>
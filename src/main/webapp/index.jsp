<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Human Cloud | HOME</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
			<li>
				<div class="search">
					<form action="">
						<label for=""></label>
						<input type="text" name="" id="" maxlength="30">
						<input type="submit">
					</form>
				</div>
			</li>
			<li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업서비스</a></li>
		</ul>
	</header>
	<div>
		<nav class="navigation">
			<a href="${pageContext.request.contextPath}/HumanCloud/RecruitmentList">전체 채용 리스트</a>
			<a href="">이력서 관리</a>
			<a href="${pageContext.request.contextPath}/HumanCloud/user/scrapList">즐겨찾기</a>
			<c:choose>
			<c:when test="${ login != null }">
				<div>
					환영합니다. ${ login.getName() } 님
					<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage">마이페이지</a>
					<a href="${pageContext.request.contextPath}/HumanCloud/user/Signout">로그아웃</a>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<a href="${pageContext.request.contextPath}/HumanCloud/user/Signin">로그인</a>
				</div>
			</c:otherwise>
			</c:choose>
		</nav>
	</div>
	<div>
		<ul class="notice">
			<c:forEach var="recruitment_list" items="${ list }" begin="0" end="8">
				<li>
					<a href="${pageContext.request.contextPath}/HumanCloud/Recruitment?recruitment_id=${recruitment_list.id}">${ recruitment_list.name }<br>
						<strong>${ recruitment_list.title }</strong>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Human Cloud | Job Offer</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
</head>
<body>
<div class="container is-max-desktop">
	<header class="section">
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
		</ul>
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
		${list}
		<ul>
			<c:forEach var="offer" items="${offerList}">
				<li>
					${companyList.get(i)} | ${offer.getStatus()} | ${offer.getOffered_at()}
				</li>
			</c:forEach>
		</ul>
		</div>
	</div>
</div>
</body>
</html>
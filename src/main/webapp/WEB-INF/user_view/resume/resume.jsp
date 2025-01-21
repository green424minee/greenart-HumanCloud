<%@page import="java.util.List"%>
<%@page import="kr.co.greenart.resume.License"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<License> licenses = (List<License>) request.getAttribute("licenses");
%>
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
			<div>
				<h2>${ login.name }님의 이력서</h2>
				<h1>${ resume.title }</h1>
			</div>
			<div >
				<p>
				${ education.school_type }
				<br>
				${ education.school_name } | ${ education.status }
				</p>
			</div>
			<div >
				${ experience.job_title }
				<br>
				${ experience.dept }
				<br>
				${ experience.position }
				<br>
				${ experience.prev_role }
				<br>
				${ experience.status }
				<br>
				${ experience.join_at }
				<br>
				${ experience.leave_or_ongoing_at }
			</div>
			<div >
				<ul>
			<%
				for (License license : licenses) {
			%>
				<li><%= license.getValue() %> | <%= license.getIssued_at() %></li>
			<%
				}
			%>
				</ul>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my/update?id=${resume.id}">이력서 수정</a>
				<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my/delete?id=${resume.id}">이력서 삭제</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>
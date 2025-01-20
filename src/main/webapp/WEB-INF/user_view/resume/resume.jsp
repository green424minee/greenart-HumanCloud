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
				<li><a href="">지원내역</a></li>
				<li><a href="">받은제안</a></li>
			</ul>
		</nav>
	</aside>
	<div>
		<h2>${ login.name }님의 이력서</h2>
		<h1>${ resume.title }</h1>
	</div>
	<div class="education">
		<p>
		${ education.school_type }
		<br>
		${ education.school_name } | ${ education.status }
		</p>
	</div>
	<div class="experience">
		${ experience }
	</div>
	<div class="licenses">
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
</body>
</html>
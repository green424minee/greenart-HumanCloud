<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>공고 | ${ recruitment.title }</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
</head>
<body>
<div class="container is-max-desktop">
	<header class="section">
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
		</ul>
	</header>
	<form method="post">
		<label for="resume">선택한 이력서</label>
		<br>
		<div class="select is-large">
		<select name="resume" id="resume">
			<c:forEach var="myResume" items="${resumeList}">
				<option value="${myResume.id}">${myResume.title}</option>
			</c:forEach>
		</select>
		</div>
		<br>
		<input type="hidden" name="recruitment_id" value="${recruitment.id}">
		<input type="submit">
	</form>
	<div></div>
</div>
</body>
</html>
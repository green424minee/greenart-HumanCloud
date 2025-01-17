<%@page import="ko.co.green.recruitment.Recruitment"%>
<%@page import="kr.co.greenart.apply.Apply"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<Apply> list = (List<Apply>) request.getAttribute("list");
	List<Recruitment> applyList = (List<Recruitment>) request.getAttribute("applyList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Human Cloud | 지원 내역</title>
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
						<li><a href="">즐겨찾기</a></li>
						<li><a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/apply">지원내역</a></li>
						<li><a href="">받은제안</a></li>
					</ul>
				</nav>
			</aside>
		</div>
		<ul>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
			<li>
			<a href="${pageContext.request.contextPath}/HumanCloud/Recruitment?recruitment_id=<%=applyList.get(i).getId()%>"><%= applyList.get(i).getTitle() %></a>
			<%= applyList.get(i).getStatus() %> |
			<%= applyList.get(i).getEnd_date() %> | 
			<%= list.get(i).getStatus() %> | 
			<%= list.get(i).getApplied_at() %>
			<a href="${pageContext.request.contextPath}/HumanCloud/Recruitment/apply/cancel?apply_id=<%=list.get(i).getId()%>">지원취소</a>
			</li>
		<%			
			}
		%>	
		</ul>
	</div>
</div>
</body>
</html>
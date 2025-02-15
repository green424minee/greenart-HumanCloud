<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<String> region = List.of("서울", "경기", "인천", "부산", "대구", "광주", "대전", "울산", "세종", "강원", "경남", "경북", "전남", "전북", "충남", "충북", "제주");
	List<String> industry = List.of("strategy", "marketing", "accounting", "hrd", "secretary", "it", "design", "trade", "md", "delivery", "service", "production", "erection", "medical", "research", "education", "media", "finance", "welfare");
	List<String> industryKor = List.of("기획/전략", "마케팅/홍보/조사", "회계/세무/재무", "인사/노무/HRD", "총무/법무/사무", "IT개발/데이터", "디자인", "영업/판매/무역", "상품기획/MD", "운전/운송/배송", "서비스", "생산", "건설/건축", "의료", "연구/R&D", "교육", "미디어/문화/스포츠", "금융/보험", "공공/복지");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Human Cloud | 공고문 리스트</title>
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
	<div class="section">
		<div >
		<div class="columns">
			<!-- 공고문 조건 설정 구역 -->
			<form method="post">
			<div class="column">
				<label for="region">지역</label>
				<div >
					<div class="select">
						<select id="region" name="region">
							<option value="">전국</option>
							<%
								for (String reg : region) {
							%>
								<option value="<%= reg %>" <%= reg.equals(request.getParameter("region")) ? "selected" : "" %>>
									<%= reg %>
								</option>
							<%
								}
							%>
						</select>
					</div>
				</div>
			</div>
			<div class="column">
				<label for="industry">직종</label>
				<div >
					<div class="select">
						<select id="industry" name="industry">
							<option value="">전국</option>
							<%
								for (int i = 0; i < industry.size(); i++) {
							%>
								<option value="<%= industry.get(i) %>" <%= industry.get(i).equals(request.getParameter("industry")) ? "selected" : "" %>>
									<%= industryKor.get(i) %>
								</option>						
							<%
								}
							%>
						</select>
					</div>
				</div>
			</div>
			<div class="column">
				<div class="field has-addons">
					<div class="control">
						<input class="input" type="text" name="keyword" placeholder="키워드검색" value="<%= request.getParameter("keyword") == null ? "" : request.getParameter("keyword") %>">
					</div>
					<div class="control">
						<input class="button is-info" type="submit" value="검색">
					</div>
				</div>
			</div>
			</form>
		</div>
		</div>
		<div class="fixed-grid has-3-cols">
		<!-- 공고문 리스트가 나올구역 -->
		<ul class="grid">
			<c:forEach var="recruitment_list" items="${ list }">
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Human Cloud | 공고문 리스트</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
		<!-- 공고문 조건 설정 구역 -->
		<form method="post">
		<label for="region">지역</label>
		<select id="region" name="region">
		<%-- 리팩토링을 통해서 선택한 옵션이 유지되도록 할 것 --%>
			<option value="">전국</option>
			<option value="서울">서울</option>
			<option value="경기">경기</option>
			<option value="인천">인천</option>
			<option value="부산">부산</option>
			<option value="대구">대구</option>
			<option value="광주">광주</option>
			<option value="대전">대전</option>
			<option value="울산">울산</option>
			<option value="세종">세종</option>
			<option value="강원">강원</option>
			<option value="경남">경남</option>
			<option value="경북">경북</option>
			<option value="전남">전남</option>
			<option value="전북">전북</option>
			<option value="충남">충남</option>
			<option value="충북">충북</option>
			<option value="제주">제주</option>
		</select>
		<label for="industry">직종</label>
		<select id="industry" name="industry">
			<option value="">전체</option>
			<option value="strategy">기획/전략</option>
			<option value="marketing">마케팅/홍보/조사</option>
			<option value="accounting">회계/세무/재무</option>
			<option value="hrd">인사/노무/HRD</option>
			<option value="secretary">총무/법무/사무</option>
			<option value="it">IT개발/데이터</option>
			<option value="design">디자인</option>
			<option value="trade">영업/판매/무역</option>
			<option value="md">상품기획/MD</option>
			<option value="delivery">운전/운송/배송</option>
			<option value="service">서비스</option>
			<option value="production">생산</option>
			<option value="erection">건설/건축</option>
			<option value="medical">의료</option>
			<option value="research">연구/R&D</option>
			<option value="education">교육</option>
			<option value="media">미디어/문화/스포츠</option>
			<option value="finance">금융/보험</option>
			<option value="welfare">공공/복지</option>
		</select>
		<input type="text" name="keyword" placeholder="키워드검색">
		<input type="submit" value="검색">
		</form>
	</div>
	<div>
		<!-- 공고문 리스트가 나올구역 -->
		<ul class="notice">
			<c:forEach var="recruitment_list" items="${ list }">
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
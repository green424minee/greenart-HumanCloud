<%@page import="kr.co.greenart.resume.License"%>
<%@page import="kr.co.greenart.resume.Experience"%>
<%@page import="kr.co.greenart.resume.Education"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<String> schoolTypeOptions = List.of("elem", "mid", "high", "univ");
	List<String> schoolTypeOptionsKor = List.of("초졸", "중졸", "고졸", "대졸");
	List<String> schoolStatusOptions = List.of("grad", "enroll", "drop");
	List<String> schoolStatusOptionsKor = List.of("졸업", "재학", "중퇴");
	List<String> industry = List.of("strategy", "marketing", "accounting", "hrd", "secretary", "it", "design", "trade", "md", "delivery", "service", "production", "erection", "medical", "research", "education", "media", "finance", "welfare");
	List<String> industryKor = List.of("기획/전략", "마케팅/홍보/조사", "회계/세무/재무", "인사/노무/HRD", "총무/법무/사무", "IT개발/데이터", "디자인", "영업/판매/무역", "상품기획/MD", "운전/운송/배송", "서비스", "생산", "건설/건축", "의료", "연구/R&D", "교육", "미디어/문화/스포츠", "금융/보험", "공공/복지");
	Education education = (Education) request.getAttribute("education");
	Experience experience = (Experience) request.getAttribute("experience");
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
			<form class="field" action="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my/update?id=${resume.id}" method="post">
			<div>
				<input type="hidden" name="resume_id" value="${ resume.id }">
				<label class="label" for="title">이력서 이름</label>
				<br>
				<input class="input" type="text" name="title" id="title" placeholder="이력서 이름" value="${ resume.title }" required="required">
			</div>
			<div>
				<p><strong>학력</strong></p>
				<div class="select">
					<select name="school_type">
						<%
							for (int i = 0; i < schoolTypeOptions.size(); i++) {
						%>
								<option value="<%= schoolTypeOptions.get(i) %>" <%= schoolTypeOptions.get(i).equals(education.getSchool_type()) ? "selected" : "" %>>
									<%= schoolTypeOptionsKor.get(i) %>
								</option>						
						<%
							}
						%>
					</select>
				</div>
				<label class="label" for="school_name">학교명</label>
				<input class="input" type="text" name="school_name" id="school_name" placeholder="사람구름대학교" value="${ education.school_name }">
				<div class="select">
					<select name="schoolStatus">
						<%
							for (int i = 0; i < schoolStatusOptions.size(); i++) {
						%>
								<option value="<%= schoolStatusOptions.get(i) %>" <%= schoolStatusOptions.get(i).equals(education.getStatus()) ? "selected" : "" %>>
									<%= schoolStatusOptionsKor.get(i) %>
								</option>						
						<%
							}
						%>
					</select>
				</div>
				<label class="label" for="adm_at">입학일</label>
				<input class="input" type="date" name="adm_at" value="${ education.adm_at }">
				<label class="label" for="grad_at">졸업일</label>
				<input class="input" type="date" name="grad_at" value="${ education.grad_at }">
			</div>
			<div>
				<p><strong>경력</strong></p>
				<div class="select">
					<select name="job_title">
						<%
							for (int i = 0; i < industry.size(); i++) {
						%>
								<option value="<%= industry.get(i) %>" <%= industry.get(i).equals(experience.getJob_title()) ? "selected" : "" %>>
									<%= industryKor.get(i) %>
								</option>						
						<%
							}
						%>
					</select>
				</div>
				<label class="label" for="dept">직책</label>
				<input class="input" type="text" name="dept" id="dept" value="${ experience.dept }">
				<label class="label" for="position">직급</label>
				<input class="input" type="text" name="position" id="position" value="${ experience.position }">
				<label class="label" for="prev_role">수행한 업무</label>
				<textarea class="textarea" name="prev_role" id="prev_role" rows="5" cols="30">${ experience.prev_role }</textarea>
				<div class="select">
					<select name="companyStatus">
						<option value="leave" <%= experience.getStatus().equals("leave") ? "seleceted" : "" %>>퇴사</option>
						<option value="ongoing" <%= experience.getStatus().equals("ongoing") ? "seleceted" : "" %>>재직</option>
					</select>
				</div>
				<label class="label" for="join_at">입사일</label>
				<input class="input" type="date" name="join_at" id="join_at" value="${ experience.join_at }">
				<label class="label" for="leave_or_ongoing_at">퇴사일</label>
				<input class="input" type="date" name="leave_or_ongoing_at" id="leave_or_ongoing_at" value="${ experience.leave_or_ongoing_at }">
			</div>
			<div>
				<ul>
					<%
						for (License license : licenses) {
					%>
						<li>
						<%= license.getValue() %> | <%= license.getIssued_at() %>
						<a href="${pageContext.request.contextPath}/HumanCloud/user/MyPage/resume/my/deleteLicense?id=${resume.id}&license_id=<%=license.getId()%>">제거하기</a>
						</li>
					<%
						}
					%>
				</ul>
				<label class="label" for="value">자격증</label>
				<input class="input" type="text" name="value" id="license">
				<label class="label" for="issued_at">취득일자</label>
				<input class="input" type="date" name="issued_at" id="issued_at">
			</div>
			<input class="button is-link" type="submit" value="작성하기">
			</form>	
		</div>
	</div>
</div>
</body>
</html>
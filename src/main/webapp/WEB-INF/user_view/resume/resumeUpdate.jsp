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
		<form method="post">
		<div>
			<input type="hidden" name="resume_id" value="${ resume.id }">
			<label for="title"></label>
			<input type="text" name="title" id="title" placeholder="이력서 이름" value="${ resume.title }" required="required">
		</div>
		<div>
			<p>학력</p>
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
			<input type="text" name="school_name" placeholder="사람구름대학교" value="${ education.school_name }">
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
			<input type="date" name="adm_at" value="${ education.adm_at }">
			<input type="date" name="grad_at" value="${ education.grad_at }">
		</div>
		<div>
			<p>경력</p>
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
			<input type="text" name="dept" value="${ experience.dept }">
			<input type="text" name="position" value="${ experience.position }">
			<textarea name="prev_role" rows="5" cols="30">${ experience.prev_role }</textarea>
			<select name="companyStatus">
				<option value="leave" <%= experience.getStatus().equals("leave") ? "seleceted" : "" %>>퇴사</option>
				<option value="ongoing" <%= experience.getStatus().equals("ongoing") ? "seleceted" : "" %>>재직</option>
			</select>
			<input type="date" name="join_at" value="${ experience.join_at }">
			<input type="date" name="leave_or_ongoing_at" value="${ experience.leave_or_ongoing_at }">
		</div>
		<div>
			<ul>
				<%
					for (License license : licenses) {
				%>
					<li>
					<%= license.getValue() %> | <%= license.getIssued_at() %>
					<a href="">제거하기</a>
					</li>
				<%
					}
				%>
			</ul>
			<label for="value">자격증</label>
			<input type="text" name="value" id="license">
			<label for="issued_at">취득일자</label>
			<input type="date" name="issued_at" id="issued_at">
		</div>
		<input type="submit" value="작성하기">
		</form>	
	</div>
</body>
</html>
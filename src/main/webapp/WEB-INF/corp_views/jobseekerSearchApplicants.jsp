<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	List<String> schoolType = List.of("elem", "mid", "high", "univ");
	List<String> schoolTypeKor = List.of("초졸", "중졸", "고졸", "대졸");
	List<String> industry = List.of("strategy", "marketing", "accounting", "hrd", "secretary", "it", "design", "trade", "md", "delivery", "service", "production", "erection", "medical", "research", "education", "media", "finance", "welfare");
	List<String> industryKor = List.of("기획/전략", "마케팅/홍보/조사", "회계/세무/재무", "인사/노무/HRD", "총무/법무/사무", "IT개발/데이터", "디자인", "영업/판매/무역", "상품기획/MD", "운전/운송/배송", "서비스", "생산", "건설/건축", "의료", "연구/R&D", "교육", "미디어/문화/스포츠", "금융/보험", "공공/복지");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>구직자 검색</title>
</head>
<body>
    <h1>구직자 검색</h1>
    <form method="post">
    	<select name="school_type">
    		<%-- 학력 조건 --%>
    		<option value="">상관없음</option>
    		<%
				for (int i = 0; i < schoolType.size(); i++) {
			%>
				<option value="<%= schoolType.get(i) %>" <%= schoolType.get(i).equals(request.getParameter("school_type")) ? "selected" : "" %>>
					<%= schoolTypeKor.get(i) %>
				</option>						
			<%
				}
			%>	
    	</select>
    	<select name="industry">
    		<%-- 경력(포지션) 조건 --%>
    		<option value="">상관없음</option>
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
    	<input type="text" name="keyword" placeholder="키워드검색" value="<%= request.getParameter("keyword") == null ? "" : request.getParameter("keyword") %>">
        <input type="submit" value="검색">
    </form>
    
    <!-- 검색 결과 표시 영역 -->
    <div>
        <!-- 여기에 검색 결과를 동적으로 표시 -->
        <ul>
        	<c:forEach var="repResume" items="${ list }">
        	<li>
        		<strong>${repResume.user_name}</strong>
        		${repResume.dept}
        		<a href="">제안하기</a>
        		<br>
        		${repResume.school_type} (${repResume.school_status})
        	</li>
        	</c:forEach>
        </ul>
    </div>
</body>
</html>

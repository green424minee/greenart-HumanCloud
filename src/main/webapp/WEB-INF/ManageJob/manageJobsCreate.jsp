<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 공고 등록 --%>

<html>
<head>
<meta charset="UTF-8">
<title>공고 등록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/HumanCloud/corp/ManageJobsCreateServlet" method="post">

		<div>
		    <label for="title">공고 제목</label>
		    <input type="text" id="title" name="recruitmentTitle" maxlength="255" value="${ job.title }" required>
		</div>
		<div>
		    <label for="description">설명</label>
		    <textarea id="description" name="recruitmentdescription">${ job.description }</textarea>
		</div>
		<div> <%-- 학력부분 추가. --%>
		    <label for="school_type">학력</label>
		    	<select id="school_type" name="school_type" required>
		        	<option value="" disabled selected>선택하세요</option>
		         	<option value="elem">초등학교 졸업</option>
			        <option value="mid">중학교 졸업</option>
			        <option value="high">고등학교 졸업</option>
			        <option value="univ">대학교 졸업</option>
			    </select>
			</div>
		<div>
		    <label for="salary">연봉</label>
		    <input type="number" id="salary" name="recruitmentSalary" value="${ job.salary }" required>
		</div>
		<div>
		    <label for="end_date">마감일</label>
		    <input type="date" id="end_date" name="recruitmentEnd_date" value="${ job.end_date }" required>
		</div>
				

	
		<input type="submit" value="공고 등록 하기">
    </form>
</body>
</html>
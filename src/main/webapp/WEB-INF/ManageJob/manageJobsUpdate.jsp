<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 수정</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/HumanCloud/corp/ManageJobsUpdateServlet" method="post">
        <input type="hidden" name="recruitmentId" value="${job.id}">
        <div>
		    <label for="status">모집 상태</label>
		    <select id="status" name="recruitmentStatus" required>
		        <option value="active" ${job.status eq 'active' ? 'selected' : ''}>진행중</option>
		        <option value="expired" ${job.status eq 'expired' ? 'selected' : ''}>마감</option>
		    </select>
		</div>
        <div>
            <label for="title">공고 제목</label>
            <input type="text" id="title" name="recruitmentTitle" maxlength="255" value="${job.title}" required>
        </div>
        <div>
            <label for="description">설명</label>
            <textarea id="description" name="recruitmentdescription">${job.description}</textarea>
        </div>
        <div>
            <label for="school_type">학력</label>
            <select id="school_type" name="school_type" required>
                <option value="elem" ${job.school_type eq 'elem' ? 'selected' : ''}>초등학교 졸업</option>
                <option value="mid" ${job.school_type eq 'mid' ? 'selected' : ''}>중학교 졸업</option>
                <option value="high" ${job.school_type eq 'high' ? 'selected' : ''}>고등학교 졸업</option>
                <option value="univ" ${job.school_type eq 'univ' ? 'selected' : ''}>대학교 졸업</option>
            </select>
        </div>
        <div>
            <label for="salary">연봉</label>
            <input type="number" id="salary" name="recruitmentSalary" value="${job.salary}" required>
        </div>
        <div>
            <label for="end_date">마감일</label>
            <input type="date" id="end_date" name="recruitmentEnd_date" value="${job.end_date}" required>
        </div>
        
        <input type="submit" value="공고 수정하기">
    </form>
</body>
</html>

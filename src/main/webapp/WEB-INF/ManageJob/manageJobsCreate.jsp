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
                <input type="text" id="title" name="recruitmentTitle" maxlength="20" value="${ olderCorp.name }" required>
            </div>
            <div>
                <label for="status">설명</label>
                <input type="text" id="status" name="recruitmentStatus" maxlength="20" value="${ olderCorp.business_reg_no }" required>
            </div>
            <div>
                <label for="salary">연봉</label>
                <input type="text" id="salary" name="recruitmentSalary" maxlength="20" value="${ olderCorp.business_reg_no }" required>
            </div>
          	<div>
                <label for="end_date">마감일</label>
                <input type="text" id="end_date" name="recruitmentEnd_date" maxlength="20" value="${ olderCorp.business_reg_no }" required>
            </div>		
		<input type="submit" value="공고 등록 하기">
    </form>
</body>
</html>
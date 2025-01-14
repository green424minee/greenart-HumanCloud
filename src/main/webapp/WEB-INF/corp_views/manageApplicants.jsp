<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>지원자 관리</title>
</head>
<body>
    <h1>지원자 관리</h1>
    <form method="post"> <!-- /HumanCloud/corp/ManageApplicantsServlet -->
        <select name="jobId">
            <!-- 여기에 공고 목록을 동적으로 표시 -->
        </select>
        <input type="submit" value="지원자 조회">
    </form>
    
    <!-- 지원자 목록 표시 영역 -->
    <div id="applicantList">
        <!-- 여기에 지원자 목록을 동적으로 표시 -->
    </div>
</body>
</html>

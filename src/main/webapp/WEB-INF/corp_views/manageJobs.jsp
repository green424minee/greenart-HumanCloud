<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>공고 관리</title>
</head>
<body>
    <h1>공고 관리</h1>
    <form method="post">
        <input type="text" name="jobTitle" placeholder="공고 제목">
        <textarea name="jobDescription" placeholder="공고 내용"></textarea>
        <input type="submit" value="공고 등록">
    </form>
    
    <!-- 공고 목록 표시 영역 -->
    <div id="jobList">
        <!-- 여기에 공고 목록을 동적으로 표시 -->
    </div>
</body>
</html>

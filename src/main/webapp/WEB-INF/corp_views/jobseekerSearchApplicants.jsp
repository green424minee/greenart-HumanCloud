<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>구직자 검색</title>
</head>
<body>
    <h1>구직자 검색</h1>
    <form action="JobseekerSearchApplicantsServlet" method="post">
        <input type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
        <input type="submit" value="검색">
    </form>
    
    <!-- 검색 결과 표시 영역 -->
    <div id="searchResults">
        <!-- 여기에 검색 결과를 동적으로 표시 -->
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>공고 관리</title>
</head>
<body>
    <h1>공고 관리</h1>
    <form method="post">
        <!-- 구현예정 -->
        <input type="submit" value="공고 등록">
        
    </form>
	<c:forEach var="recru" items="${ list }">
		<div>
			<h3>제목: ${ recru.title }</h3>
			<p>공고진행: ${ recru.status }</p>
			<p>설명: ${ recru.description }</p>
			<p>연봉: ${ recru.salary }</p>
			<p>마감기한: ${ recru.end_date }</p>
			<p>수정 시간: ${ recru.created_at }</p>
			<p>업로드 시간: ${ recru.updated_at }</p>
		</div>
	</c:forEach>    
</body>
</html>

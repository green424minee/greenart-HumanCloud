<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>지원자 관리</title>
</head>
<body>
    <header>
        <ul>
            <li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
            <li></li>
            <li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업서비스</a></li>
        </ul>
    </header>

    <div class="content">
        <h2>지원자 관리</h2>
    
        <div class="control-buttons">
            <a href="?status=all"><button>지원자 조회</button></a>
            <a href="?status=first"><button>1차 합격</button></a>
            <a href="?status=final"><button>합격자 조회</button></a>
        </div>

</body>
</html>

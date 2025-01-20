<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 index</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <div class="nav-buttons">
            <li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex"><button class="btn-signup" >기업홈</button></a></li>            
            <li><a href="${pageContext.request.contextPath}"><button class="btn-signup" >개인홈</button></a></li>
        </div>



        <div class="header">
            <div class="top-menu">
                <c:choose>
                    <c:when test="${not empty sessionScope.corp}">
                        <p>환영합니다, ${sessionScope.corp.name}님</p>
                        <a href="${pageContext.request.contextPath}/HumanCloud/corp/Logout"><button class="btn-logout">로그아웃</button></a>
                    </c:when>
                    <c:otherwise>
                        <div class="button-group">
                            <a href="${pageContext.request.contextPath}/HumanCloud/corp/Signin"><button class="btn-login">로그인</button></a>
                            <a href="${pageContext.request.contextPath}/HumanCloud/corp/Signup"><button class="btn-signup">회원가입</button></a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        
			<div class="">
                <h2>구직자</h2>
                <a href="${pageContext.request.contextPath}/HumanCloud/corp/SearchApplicantsServlet"><button class="btn-manage-info">구직자 검색</button></a>
            </div>
        
        <c:if test="${not empty sessionScope.corp}">
            <div class="job-manage">
                <h2>공고관리</h2>
                <a href="${pageContext.request.contextPath}/HumanCloud/corp/ManageJobsServlet"><button class="btn-manage-info">공고 등록 / 관리</button></a>
            </div>
            
<div class="applicant-manage">
    <h2>지원자 관리</h2>
    <a href="${pageContext.request.contextPath}/HumanCloud/corp/ManageApplicantsServlet">
        <button class="btn-manage-info">지원자 조회 / 관리</button>
    </a> 	
</div>
            <div class="company-manage">
                <h2>기업관리</h2>
                <a href="${pageContext.request.contextPath}/HumanCloud/corp/CorpManageInfo"><button class="btn-manage-info">기업 정보 관리</button></a>
            </div>
        </c:if>
    </div>
</body>
</html>

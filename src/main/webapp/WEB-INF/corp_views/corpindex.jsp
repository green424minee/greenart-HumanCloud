<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.co.green.corp.Corp" %>
<%
  boolean isLoggedIn = (session.getAttribute("corp") != null);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 인덱스</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <!-- 메인 컨텐츠 -->
        <div class="main-content">
            <!-- 검색 영역 -->
            <div class="search-section">
                <!-- 공고 검색 -->
                <div class="search-box">
                    <input type="text" placeholder="공고검색" class="search-input">
                    <div class="search-info">
                        <p></p>
                    </div>
                </div>
                <!-- 구직자 검색 -->
                <div class="search-box">
                    <input type="text" placeholder="구직자검색" class="search-input">
                    <div class="search-info">
                    </div>
                </div>
            </div>
        </div>

        <!-- 우측 로그인 영역 -->
        <div class="login-section">
            <div class="login-box">
                <% if (isLoggedIn) { %>
                    <p>환영합니다, <%= ((Corp)session.getAttribute("corp")).getName() %>님</p>
                    <a href="${pageContext.request.contextPath}/HumanCloud/corp/Logout"><button class="btn-logout">로그아웃</button></a>
                    
                    <!-- 추가된 부분: 기업 정보 관리 버튼 -->
                    <a href="${pageContext.request.contextPath}/HumanCloud/corp/CorpManageInfo"><button class="btn-manage-info">기업 정보 관리</button></a>
               		<!-- 추가된 부분 끝 -->
               
                <% } else { %>
                    <p>환영합니다</p>
                    <p>로그인을 이용해세요</p>
                    <div class="button-group">
                        <a href="${pageContext.request.contextPath}/HumanCloud/corp/Signin"><button class="btn-login">로그인</button></a>
                        <a href="${pageContext.request.contextPath}/HumanCloud/corp/Signup"><button class="btn-signup">회원가입</button></a>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 인덱스</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

        <!-- 메인 컨텐츠 -->
        <div class="main-content">
            <!-- 상단 헤더 -->
            <div class="header">
                <div class="logo-area">
                    <h1>Human Cloud</h1>
                    <span>기업홈</span>
                </div>
                <div class="top-menu">
                    <span class="saramin-text">Human Cloud</span>
                    <span>로그인</span>
                    <span>회원기업</span>
                </div>
            </div>

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
                        <p>구직자 검색</p>
                        <p>원하는 조건의 구직자 검색가능</p>
                        <p>구직자와의 협의필요</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- 우측 로그인 영역 -->
        <div class="login-section">
            <div class="login-box">
                <p>환영합니다</p>
                <p>로그인을 이용해세요</p>
                <div class="button-group">
                    <button class="btn-login">로그인</button>
                    <a href="${pageContext.request.contextPath}/HumanCloud/corp/Signup"><button class="btn-signup" >신규가입</button></a>
                </div>
            </div>
            <div class="info-box">
                <p></p>
                <p></p>
                <p>프로필보기</p>
            </div>
        </div>
    </div>
</body>
</html>

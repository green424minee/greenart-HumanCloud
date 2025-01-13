<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 로그인 | HumanCloud</title>
</head>
<body>
    <header>
        <ul>
            <li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex"><button class="btn-signup" >기업홈</button></a></li>
        </ul>
    </header>

    <form method="post" >
        <label for="corpid">아이디</label>
        <input type="text" name="corpid" id="corpid" maxlength="20" placeholder="최대 20글자" required="required">
        
        <label for="password">비밀번호</label>
        <input type="password" name="password" id="password" maxlength="20" placeholder="최대 20글자" required="required">
        

        <input type="submit" value="로그인">
    </form>


    <div class="signup-link">
		<a href="${pageContext.request.contextPath}/HumanCloud/corp/Signup"><button class="btn-signup" >회원가입</button></a>
    </div>

    <!-- 유효성 검사 추가 -->
    <script>
        const form = document.getElementById("loginForm");
        const corpidInput = document.getElementById("corpid");
        const passwordInput = document.getElementById("password");

        form.addEventListener("submit", function(event) {
            event.preventDefault();
            if (validateForm()) {
                form.submit();
            }
        });

        function validateForm() {
            const corpid = corpidInput.value.trim();
            const password = passwordInput.value.trim();

            if (corpid === "") {
                alert("기업 아이디를 입력해주세요");
                return false;
            }
            if (password === "") {
                alert("비밀번호를 입력해주세요");
                return false;
            }
            return true;
        }
    </script>
</body>

<% if (request.getAttribute("loginFailed") != null && (boolean)request.getAttribute("loginFailed")) { %>
    <script>
        alert("아이디 또는 비밀번호가 올바르지 않습니다. 다시 확인해주세요.");
    </script>
<% } %>

</html>

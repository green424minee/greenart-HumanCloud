<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Corp SIGN UP</title>
</head>
<body>
    <header>
    
    </header>
    <div>
        <form method="post">
            <label for="business_reg_no">사업자등록번호</label>
            <input type="text" name="business_reg_no" id="business_reg_no" required="required">
            
            <label for="name">회사 이름</label>
            <input type="text" name="name" id="name" required="required">
            
            <label for="corpid">아이디</label>
            <input type="text" name="corpid" id="corpid" maxlength="20" placeholder="최대 20글자" required="required">
            
            <label for="password">비밀번호</label>
            <input type="password" name="password" id="password" maxlength="20" placeholder="최대 20글자" required="required">
            
            <label for="passwordCheck">비밀번호 확인</label>
            <input type="password" name="passwordCheck" id="passwordCheck" maxlength="20" placeholder="최대 20글자" required="required">
            
            <label for="contact">연락처</label>
            <input type="text" name="contact" id="contact" placeholder="010-0000-0000" required="required">
            
            <label for="email">회사 이메일</label>
            <input type="email" name="email" id="email" placeholder="email@company.com" required="required">
            
            <label for="owner">대표자</label>
            <input type="text" name="owner" id="owner" required="required">
            
            <label for="address">회사 주소</label>
            <input type="text" name="address" id="address" required="required">
            
            <input type="submit" value="회원가입 확인">
        </form>
    </div>
</body>
</html>

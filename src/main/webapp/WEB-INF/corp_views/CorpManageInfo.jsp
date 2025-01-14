<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>기업 정보 관리</title>
</head>
<body>
    <div class="container">
        <h2>기업 정보 관리</h2>
        
        <form method="POST">
            <div class="form-group">
                <label for="corpname">기업명:</label>
                <input type="text" id="corpname" name="name" maxlength="20" required
                	value="${ olderCorp.name }">
            </div>
            
            <div class="form-group">
                <label for="business_reg_no">사업자등록번호:</label>
                <input type="text" id="business_reg_no" name="business_reg_no" maxlength="20" required
                	value="${ olderCorp.business_reg_no }">
            </div>
            
            <div class="form-group">
                <label for="description">기업 설명:</label>
                <textarea id="description" name="description" rows="4" maxlength="255">${ olderCorp.description }</textarea>
            </div>
            
            <div class="form-group">
                <label for="contact">연락처:</label>
                <input type="text" id="contact" name="contact" maxlength="20"
                	value="${ olderCorp.contact }">
            </div>
            
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" id="email" name="email" maxlength="40"
                	value="${ olderCorp.email }">
            </div>
            
            <div class="form-group">
                <label for="owner">대표자:</label>
                <input type="text" id="owner" name="owner" maxlength="10"
                	value="${ olderCorp.owner }">
            </div>
            
            <div class="form-group">
                <label for="website">웹사이트:</label>
                <input type="url" id="website" name="website" maxlength="50"
                	value="${ olderCorp.website }">
            </div>
            
            <div class="form-group">
                <label for="emp_count">직원 수:</label>
                <input type="number" id="emp_count" name="emp_count"
                	value="${ olderCorp.emp_count }">
            </div>
            
            <div class="form-group">
                <label for="sales">매출액:</label>
                <input type="number" id="sales" name="sales"
                	value="${ olderCorp.sales }">
            </div>
            
            <div class="form-group">
                <label for="address">주소:</label>
                <input type="text" id="address" name="address" maxlength="255"
                	value="${ olderCorp.address }">
            </div>
            
            <div class="form-group">
                <label for="image">기업 이미지:</label>
                <input type="file" id="image" name="image" accept="image/*">
            </div>
            
            <div class="form-group">
                <button type="submit" class="btn">저장</button>
                <button type="reset" class="btn">초기화</button>
            </div>
        </form>
    </div>
</body>
</html>

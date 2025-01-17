<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>공고 관리</title>
	<link rel="stylesheet" href="css/style.css">    
</head>
<body>
	<header>
		<ul>
			<li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
			<li>
			</li>
			<li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업서비스</a></li>
		</ul>
	</header>

    <div class="content">
        <h2>공고 관리</h2>
        
	<div>
		<a href="${pageContext.request.contextPath}/HumanCloud/corp/ManageJobsCreateServlet"><button class="btn-manage-info">공고등록</button></a> 	
    </div>
    
	<div class="control-buttons">
	    <a href="?status=active"><button>진행중인 공고</button></a>
	    <a href="?status=expired"><button>종료된 공고</button></a>
	 	<a href="?status=all"><button>전체 조회</button></a>
	</div>
	


        <div class="notice-list">
            <c:forEach var="recru" items="${list}">
                <div class="notice-item">
                    <div class="notice-main-info">
                        <h3>${recru.title}</h3>
                        <span>마감: ${recru.end_date}</span>
                    </div>
                    <div class="notice-detail">
                        <p>모집 상태: ${recru.status}</p>
                        <p>회사 설명: ${recru.description}</p>
                        <p>학력: ${recru.school_type}</p>
                        <p>연봉: ${recru.salary}</p>
                    </div>
					<div class="notice-buttons">
					    <button>지원자 확인</button>
					    
						<c:if test="${recru.status eq 'active'}">
					        <form action="ManageJobsServlet" method="post" style="display:inline;">
					            <button type="submit" name="recruitmentId" value="${recru.id}">마감</button>
					        </form>
					    </c:if>
					    
						<form action="${pageContext.request.contextPath}/HumanCloud/corp/ManageJobsUpdateServlet" method="get" style="display:inline;">
						    <input type="hidden" name="recruitmentId" value="${recru.id}">
						    <button type="submit">공고수정</button>
						</form>
						<form action="${pageContext.request.contextPath}/HumanCloud/corp/ManageJobsDeleteServlet" method="post">
						    <input type="hidden" name="recruitmentId" value="${recru.id}">
						    <button type="submit" onclick="return confirm('정말 삭제하시겠습니까?')">공고삭제</button>
						</form>
						
					</div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>

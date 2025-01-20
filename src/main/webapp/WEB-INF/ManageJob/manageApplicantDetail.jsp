<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>지원자 상세정보</title>
</head>
<body>
    <header>
        <ul>
            <li><a href="${pageContext.request.contextPath}">HumanCloud</a></li>
            <li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업서비스</a></li>
        </ul>
    </header>

    <div class="content">
        <h2>지원자 이력서</h2>
       
        <div class="resume-header">
		    <h3>지원자: ${userName}</h3>
		    <h3>${resume.title}</h3>
		</div>
        
        <div class="basic-info">
            <h4>기본 정보</h4>
			<p>지원 상태: ${apply.status}</p>
            <p>경력: ${experiencePeriod}</p>
            <p>최종학력: ${finalEducation}</p>
        </div>
        
        <div class="education-info">
            <h4>학력사항</h4>
            <p>학교구분: ${education.school_type}</p>
            <p>학교명: ${education.school_name}</p>
            <p>상태: ${education.status}</p>
            <p>입학일: ${education.adm_at}</p>
            <p>졸업일: ${education.grad_at}</p>
        </div>
        
        <div class="experience-info">
            <h4>경력사항</h4>
            <p>직무: ${experience.job_title}</p>
            <p>부서: ${experience.dept}</p>
            <p>직급: ${experience.position}</p>
            <p>담당업무: ${experience.prev_role}</p>
            <p>상태: ${experience.status}</p>
            <p>입사일: ${experience.join_at}</p>
            <p>퇴사일: ${experience.leave_or_ongoing_at}</p>
        </div>
        
        <div class="license-info">
            <h4>자격증</h4>
            <c:forEach var="license" items="${licenses}">
                <div>
                    <p>자격증명: ${license.value}</p>
                    <p>취득일: ${license.issued_at}</p>
                </div>
            </c:forEach>
        </div>
        
        <!-- 상태 변경 버튼 -->
        <div class="status-buttons">
            <c:choose>
                <c:when test="${apply.status eq 'applied'}">
                    <form action="ManageApplicantsServlet" method="post">
                        <input type="hidden" name="apply_id" value="${apply.id}">
                        <input type="hidden" name="action" value="interview">
                        <input type="hidden" name="id" value="${param.id}">
                        <input type="hidden" name="status" value="${param.status}">
                        <button type="submit">면접대상자 선정</button>
                    </form>
                </c:when>
                <c:when test="${apply.status eq 'interview'}">
                    <form action="ManageApplicantsServlet" method="post" style="display:inline;">
                        <input type="hidden" name="apply_id" value="${apply.id}">
                        <input type="hidden" name="action" value="hired">
                        <input type="hidden" name="id" value="${param.id}">
                        <input type="hidden" name="status" value="${param.status}">
                        <button type="submit">합격</button>
                    </form>
                    <form action="ManageApplicantsServlet" method="post" style="display:inline;">
                        <input type="hidden" name="apply_id" value="${apply.id}">
                        <input type="hidden" name="action" value="rejected">
                        <input type="hidden" name="id" value="${param.id}">
                        <input type="hidden" name="status" value="${param.status}">
                        <button type="submit">불합격</button>
                    </form>
                </c:when>
            </c:choose>
        </div>
        
        <div class="back-button">
            <a href="javascript:history.back()"><button>목록으로 돌아가기</button></a>
        </div>
    </div>
</body>
</html>

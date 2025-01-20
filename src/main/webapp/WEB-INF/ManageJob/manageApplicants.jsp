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
            <li><a href="${pageContext.request.contextPath}/HumanCloud/corpindex">기업서비스</a></li>
        </ul>
    </header>

    <div class="content">
        <h2>지원자 관리</h2>
        
        <!-- 공고 목록 -->
        <div class="recruitment-list">
            <h3>공고 목록</h3>
            <c:forEach var="recruitment" items="${recruitments}">
                <div>
                    <h4>${recruitment.title}</h4>
                    <a href="?id=${recruitment.id}&status=all">
                        <button>지원자 확인</button>
                    </a>
                </div>
            </c:forEach>
        </div>

        <!-- 선택된 공고의 지원자 목록 -->
        <c:if test="${not empty param.id}">
            <div class="control-buttons">
                <a href="?id=${param.id}&status=all"><button>전체 조회</button></a>
                <a href="?id=${param.id}&status=applied"><button>지원자 조회</button></a>
                <a href="?id=${param.id}&status=interview"><button>면접자 조회</button></a>
                <a href="?id=${param.id}&status=hired"><button>합격자 조회</button></a>
            </div>

            <div class="applicant-list">
                <c:choose>
                    <c:when test="${empty applies}">
                        <p>해당 상태의 지원자가 없습니다.</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="apply" items="${applies}">

<div class="applicant-item">
    <div class="resume-header">
        <a href="${pageContext.request.contextPath}/HumanCloud/corp/ManageApplicantDetailServlet?apply_id=${apply.id}">
            <h3>${resumeMap[apply.id].title}</h3>
        </a>
        <p>지원자: ${nameMap[apply.id]}</p>
        <p>학력: ${educationMap[apply.id]}</p>
        <p>경력: ${experienceMap[apply.id]}</p>
    </div>

    <!-- 상태 변경 버튼 -->
    <div>
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
</div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:if>
    </div>
</body>
</html>

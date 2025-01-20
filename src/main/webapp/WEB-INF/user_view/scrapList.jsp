<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>스크랩 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
</head>
<body>
<div class="container is-fullhd">
	<header>
		<h3 class="title is-3">스크랩 목록</h3>
	</header>
	
	<article>
		<div class="block">
			전체(${ scrapCount })
		</div>
		
		<div class="block">
			<form>
				<input type="hidden" name="formType" value="sort">
				
				<label for="sortType">정렬</label>
				<select id="sortType" name="sortType" onchange="this.form.submit()">
					<option value="scrap_at_asc" ${selectedSortType == 'scrap_at_asc' ? 'selected' : ''}>스크랩일순</option>
					<option value="end_date_asc" ${selectedSortType == 'end_date_asc' ? 'selected' : ''}>마감일순</option>
				</select>
			</form>
		</div>
		
		<div class="block">
			<c:forEach var="scrap" items="${ scrapList }">
				<div>
					<form method="post" action="${pageContext.request.contextPath}/HumanCloud/user/scrapList">
						<input type="hidden" name="formType" value="delete">
						<input type="hidden" name="id" value="${ scrap.id }">
						<button>삭제</button>
					</form>
				</div>
				<div class="block">
					<strong>${ scrap.corp_name } | ${ scrap.recr_title } | ${ scrap.end_date } | ${ scrap.scrap_at }</strong>
				</div>
				<hr>
			</c:forEach>
		</div>
	</article>
</div>
</body>
</html>
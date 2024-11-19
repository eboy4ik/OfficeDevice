<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><c:out value="${pageTitle}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modalwindow.css">
</head>

<body>


<!-- Header -->
<div class="sticky-header-container">
    <jsp:include page="${userHeader}"/>
</div>

<!-- Main content -->
<div id="content">
    <jsp:include page="${contentPage}"/>
</div>

<script charset="UTF-8" src="${pageContext.request.contextPath}/js/modalwindow.js"></script>

</body>
</html>
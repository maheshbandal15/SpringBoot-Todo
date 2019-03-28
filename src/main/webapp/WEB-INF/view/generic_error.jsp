<!DOCTYPE html >
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta charset="utf-8">
<title>Error Page</title>
<jsp:include page="stylesheet.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="LoginModal.jsp"></jsp:include>
	<div>
	<c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h4>${errMsg}</h4>
	</c:if>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>
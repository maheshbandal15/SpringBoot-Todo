<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>All Users Page Using Microservice</title>
<jsp:include page="stylesheet.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="LoginModal.jsp"></jsp:include>
	<div class="container text-center" id="tasksDiv">
				<h3>Welcome ${user.firstName} </h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Username</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Mobile Number</th>
								<th>Email Id</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.uId}</td>
									<td>${user.userName}</td>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.mobileNumber}</td>
									<td>${user.emailId}</td>
									<td><a href="#"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="#"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<%-- <td><a href="/delete-user?id=${user.userId}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-user?id=${user.userId}"><span
											class="glyphicon glyphicon-pencil"></span></a></td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>
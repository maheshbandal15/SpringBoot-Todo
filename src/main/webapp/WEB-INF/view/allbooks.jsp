<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Book Library</title>
<jsp:include page="stylesheet.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
  	<jsp:include page="LoginModal.jsp"></jsp:include>
  	<h3>Welcome, ${user.firstName}  to your Library</h3>
  	<div class="container text-center" id="tasksDiv">
				<h3>Welcome ${user.firstName} , to your Library</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Book Name</th>
								<th>Author Name</th>
								<th>Publication</th>
								<th>Price</th>
								<th>Edition</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books }">
								<tr>
									<td>${book.bookId}</td>
									<td>${book.title}</td>
									<td>${book.author.name}</td>
									<td>${book.publication}</td>
									<td>${book.price}</td>
									<td>${book.edition}</td>
									<td><a href="/delete-book?id=${book.bookId}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-book?id=${book.bookId}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
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
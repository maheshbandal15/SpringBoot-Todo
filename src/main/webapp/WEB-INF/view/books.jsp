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
<title>Insert Books to you library</title>
<jsp:include page="stylesheet.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<jsp:include page="LoginModal.jsp"></jsp:include>
	<c:choose>
		<c:when test="${mode=='MODE_REGISTER' }">
		<h3>Welcome, ${person.firstName} Add Books to your Library</h3>
		<div class="container text-center">
			<h3>Welcome, ${person.firstName} Add Books to your Library</h3>
			<hr>
			<form class="form-horizontal" method="POST" action="book/addbook">
				<input type="hidden" name="uId" value="uId" />
				<div class="form-group">
					<label class="control-label col-md-3">Book Title</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="title" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3">Publication</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="publication" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Price</label>
					<div class="col-md-3">
						<input type="number" class="form-control" name="price"
							step="any" onkeyup="validateNum(this);" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Edition</label>
					<div class="col-md-3">
						<input type="text" class="form-control" name="edition" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Author</label>
					<div class="col-md-7">
						<%-- <c:select path="author"> --%>
						<select name="author" class="form-control">
							<c:forEach items="${authorList}" var="author">
								<%-- <option value="${author}">${author.name}</option> --%>
								<option value="${author.id}">${author.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group ">
					<input type="submit" class="btn btn-primary" value="Add Book" />
				</div>
			</form>
		</div>
		</c:when>
		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
			<h3>Welcome, ${person.firstName} Add Books to your Library</h3>
			<hr>
			<form class="form-horizontal" method="POST" action="book/book-update">
				<input type="hidden" name="uId" value="${book.bookId }" />
				<div class="form-group">
					<label class="control-label col-md-3">Book Title</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="title" 
						value= "${book.title}"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3">Publication</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="publication"
						value= "${book.publication}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Price</label>
					<div class="col-md-3">
						<input type="number" min="1" class="form-control" name="price"
							step="any" value= "${book.price}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Edition</label>
					<div class="col-md-3">
						<input type="text" class="form-control" name="edition"
						 value= "${book.edition}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Author</label>
					<div class="col-md-7">
						<%-- <c:select path="author"> --%>
						<select name="author" class="form-control">
							<c:forEach items="${authorList}" var="author">
								<%-- <option value="${author}">${author.name}</option> --%>
								<option value="${author.id}"
								<c:if test="${author.id eq selectedCatId}">selected="selected"</c:if> 
								>
								${author.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group ">
					<input type="submit" class="btn btn-primary" value="Update Book" />
				</div>
			</form>
		</div>
		</c:when>
	</c:choose>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>
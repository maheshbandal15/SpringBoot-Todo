<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="stylesheet.jsp"></jsp:include>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	  <jsp:include page="LoginModal.jsp"></jsp:include>
	<div class="container text-center">
		<h3>New Registration</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="user/adduser">
			<input type="hidden" name="uId" value="uId" />
			<div class="form-group">
				<label class="control-label col-md-3">Username</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="userName"
						 />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">First Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="firstName"
						 />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Last Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="lastName"
						 />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Mobile Number</label>
				<div class="col-md-3">
					<input type="number" class="form-control" name="mobileNumber"
						 />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Email-Id</label>
				<div class="col-md-3">
					<input type="email" class="form-control" name="emailId"
						onchange="email_validate(this.value);" />
						<div class="status" id="status"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Password</label>
				<div class="col-md-7">
					<input type="password" class="form-control" name="password"
						/>
				</div>
			</div>
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Register" />
			</div>
		</form>
	</div>
	<%-- <div class="container text-center">
	</div>
	<jsp:include page="footer.jsp"></jsp:include> --%>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>
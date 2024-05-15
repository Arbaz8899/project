<%@page import="com.model.User"%>
<%@page import="com.entities.Message"%>
<%@page import="com.techblog.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>

<!-- css -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
.banner-background {
	clip-path: polygon(30% 0%, 100% 0, 100% 30%, 100% 93%, 66% 100%, 34% 92%, 0 100%, 0
		0);
}
</style>


</head>
<body>

	<!-- navbar -->

	<%@include file="navbar.jsp"%>

	<main class="primary-background banner-background"
		style="padding-bottom: 63px; padding-top: 10px">
		<div class="container">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center primary-background text-white">
						<span class="fa fa-2x fa-user-plus"></span> <br> Register
						here
					</div>

					<%
					Message m = (Message) session.getAttribute("msg");
					if (m != null) {
					%>
					<div class="alert <%=m.getCssClass()%>" role="alert">
						<%=m.getContent()%>
					</div>

					<%
					session.removeAttribute("msg");
					}
					%>

					<div class="card-body">
						<form id="reg-form" action="UserServlet" method="post">
							<div class="form-group">
								<label for="user_name">User Name</label> <input type="text"
									name="name" required="required" class="form-control"
									id="user_name" aria-describedby="emailHelp"
									placeholder="Enter name">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email" required="required"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="password" required="required"
									class="form-control" id="exampleInputPassword1"
									placeholder="Password">
							</div>

							<div class="form-group">
								<label for="gender">Select Gender</label> <br> <input
									type="radio" id="gender" name="gender" value="male">Male
								<input type="radio" id="gender" name="gender"
									required="required" value="female">Female
							</div>

							<div class="form-check">
								<input name="check" type="checkbox" class="form-check-input">
								<label class="form-check-label">agree terms and
									conditions</label>
							</div>
							<br>
							<button type="submit" name="b1" value="submit"
								class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- Javascripts -->

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js/1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"
		integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"
		integrity="sha512-bztGAvCE/3+a1Oh0gUro7BHukf6v7zpzrAb3ReWAVrt+bVNNphcl2tDTKCBr5zk7iEDmQ2Bv401fX3jeVXGIcA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="my.js" type="text/javascript"></script>
	
</body>
</html>
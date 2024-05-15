<%@page import="com.techblog.dao.LikeDao"%>
<%@page import="com.techblog.dao.UserDao"%>
<%@page import="com.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.Post"%>
<%@page import="com.techblog.helper.ConnectionProvider"%>
<%@page import="com.techblog.dao.PostDao"%>
<%@page import="com.model.User"%>
<%@page errorPage="error-page.jsp"%>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	response.sendRedirect("login-page.jsp");
}
%>

<%
int postId = Integer.parseInt(request.getParameter("post_id"));
PostDao d = new PostDao(ConnectionProvider.getConnection());
Post p = d.getPostByPostId(postId);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=p.getpTitle()%></title>
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

.post-title {
	font-weight: 100;
	font-size: 25px;
}

.post-content {
	font-weight: 100;
	font-size: 20px;
}

.post-date {
	font-style: italic;
}

.post-name {
	font-style: italic;
}

.row-user {
	border: 1px solid #e2e2e2;
	padding-top: 10px;
}
</style>
</head>
<body>

	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="#"><span class="fa fa-asterisk"></span>
			Tech Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"><span class="fa fa-home"></span> Home</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><span class="fa fa-navicon"></span>
						Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Programming Language</a> <a
							class="dropdown-item" href="#">Project Implementation</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Data Structure</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#"><span
						class="fa fa-phone-square"></span> Contacts</a></li>

				<li class="nav-item"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#post-modal"><span
						class="fa fa-send"></span> Post</a></li>
			</ul>
			<ul class="navbar-nav mr-right">
				<li class="nav-item"><a class="nav-link" href="#!"
					data-toggle="modal" data-target="#profile-modal"><span
						class="fa fa-user-circle"></span> <%=user.getName()%></a></li>

				<li class="nav-item"><a class="nav-link" href="LogoutServlet"><span
						class="fa fa-toggle-on"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
	<!-- end of navbar -->

	<!-- main content of the body -->
	<div class="container">
		<div class="row my-4">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-header bg-primary text-white">
						<h4 class="post-title"><%=p.getpTitle()%></h4>
					</div>
					<div class="card-body">
						<img class="card-img-top my-2" src="blog-pics/<%=p.getpPic()%>"
							alt="Card image cap">

						<div class="row my-3 row-user">
							<div class="col-md-8">
								<%
								UserDao ud = new UserDao(ConnectionProvider.getConnection());
								%>
								<p class="post-name">
									<a href="#"><%=ud.getUserByUserId(p.getUserId()).getName()%></a>
									has posted on :
								</p>
							</div>
							<div class="col-md-4">
								<p class="post-date"><%=p.getpDate().toLocaleString()%></p>
							</div>
						</div>

						<p class="post-content"><%=p.getpContent()%></p>
						<br>
						<div class="post-code">
							<pre><%=p.getpCode()%></pre>
						</div>
					</div>
					<div class="card-footer bg-primary">
					
					<%
						LikeDao ld  = new LikeDao(ConnectionProvider.getConnection());
					%>
					
						<a onclick="doLike(<%=p.getpId()%>,<%=user.getId()%>)"
							class="btn btn-outline-light btn-sm">
							<i class="fa fa-thumbs-o-up"></i><span class="like-counter"><%=ld.countLikeOnPost(p.getpId()) %></span></a> <a
							href="#" class="btn btn-outline-light btn-sm"><i
							class="fa fa-commenting-o"></i><span>10</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- end of main content of the body -->

	<!-- profile modal -->

	<!-- Modal -->
	<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<h5 class="modal-title" id="exampleModalLabel"><%=user.getName()%></h5>
						<!-- Details -->
						<div id="profile-details">
							<table class="table">
								<tbody>
									<tr>
										<th scope="row">ID :</th>
										<td><%=user.getId()%></td>
									</tr>
									<tr>
										<th scope="row">Email :</th>
										<td><%=user.getEmail()%></td>
									</tr>
									<tr>
										<th scope="row">Gender :</th>
										<td><%=user.getGender().toUpperCase()%></td>
									</tr>
								</tbody>
							</table>
						</div>

						<!-- profile edit -->
						<div id="profile-edit" style="display: none">
							<h3 class="mt-2">Please Edit Carefully</h3>
							<form action="EditServlet" method="post">
								<table class="table">
									<tr>
										<td>ID :</td>
										<td><%=user.getId()%></td>
									</tr>
									<tr>
										<td>Name :</td>
										<td><input type="text" class="form-control" name="name"
											value="<%=user.getName()%>"></td>
									</tr>
									<tr>
										<td>Email :</td>
										<td><input type="email" class="form-control" name="email"
											value="<%=user.getEmail()%>"></td>
									</tr>
									<tr>
										<td>Password :</td>
										<td><input type="password" class="form-control"
											name="password" value="<%=user.getPassword()%>"></td>
									</tr>
									<tr>
										<td>Gender :</td>
										<td><%=user.getGender().toUpperCase()%></td>
									</tr>
								</table>
								<div class="container">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
							</form>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="edit-profile-btn" type="button" class="btn btn-primary">Edit</button>
				</div>
			</div>
		</div>
	</div>

	<!-- end of profile modal -->

	<!-- Post modal -->

	<!-- Modal -->
	<div class="modal fade" id="post-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Provide the
						post details..</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="post-form" action="PostServlet" method="post"
						enctype="multipart/form-data">

						<div class="form-group">
							<select class="form-control" name="cid">
								<option selected="selected" disabled="disabled">---Select
									Category---</option>

								<%
								PostDao postd = new PostDao(ConnectionProvider.getConnection());
								ArrayList<Category> list = postd.getAllCategories();

								for (Category c : list) {
								%>
								<option value="<%=c.getCid()%>"><%=c.getName()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="form-group">
							<input name="pTitle" type="text" placeholder="Enter post Title"
								class="form-control" />
						</div>

						<div class="form-group">
							<textarea name="pContent" class="form-control"
								placeholder="Enter your content"></textarea>
						</div>

						<div class="form-group">
							<textarea name="pCode" class="form-control"
								placeholder="Enter your program (if any)"></textarea>
						</div>

						<div class="form-group">
							<label>Select your pic</label> <br> <input type="file"
								name="pPic">
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-outline-primary">Post</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Back</button>
				</div>
			</div>
		</div>
	</div>

	<!-- end of post modal -->

	<!-- Javascripts -->

	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"
		integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js"
		integrity="sha512-bztGAvCE/3+a1Oh0gUro7BHukf6v7zpzrAb3ReWAVrt+bVNNphcl2tDTKCBr5zk7iEDmQ2Bv401fX3jeVXGIcA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="my.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			let editStatus = false;

			$('#edit-profile-btn').click(function() {
				if (editStatus == false) {
					$('#profile-details').hide()

					$('#profile-edit').show()
					editStatus = true;
					$(this).text("Back")
				} else {
					$('#profile-details').show()

					$('#profile-edit').hide()
					editStatus = false;
					$(this).text("Edit")
				}
			})
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function(e) {
			$("#post-form").on("submit", function(event) {
				//event.preventDefault();
				console.log("you have clicked on save..")
			})
		})
	</script>

</body>
</html>
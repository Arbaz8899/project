<%@page import="com.model.User"%>
<%@page import="com.techblog.dao.LikeDao"%>
<%@page import="com.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.techblog.helper.ConnectionProvider"%>
<%@page import="com.techblog.dao.PostDao"%>

<div class="row">
	<%
	User uuu =(User) session.getAttribute("currentUser");
	
	Thread.sleep(500);
	PostDao d = new PostDao(ConnectionProvider.getConnection());

	int cid = Integer.parseInt(request.getParameter("cid"));
	List<Post> posts = null;
	if (cid == 0) {
		posts = d.getAllPost();
	} else {
		posts = d.getPostByCatId(cid);
	}
	if (posts.size() == 0) {
		out.println("<h3 class='display-2 text-center'>No Posts in this category...</h3>");
	}
	for (Post p : posts) {
	%>

	<div class="col-md-6 mt-2">
		<div class="card">
			<img class="card-img-top" src="blog-pics/<%=p.getpPic()%>"
				alt="Card image cap">
			<div class="card-body">
				<b><%=p.getpTitle()%></b>
				<p><%=p.getpContent()%></p>
			</div>
			<div class="card-footer bg-primary">

				<%
				LikeDao ld = new LikeDao(ConnectionProvider.getConnection());
				%>

				<a href="show-blog-page.jsp?post_id=<%=p.getpId()%>"
					class="btn btn-outline-light btn-sm">Read More...</a> <a 
					onclick="doLike(<%=p.getpId()%>,<%=uuu.getId()%>)"
					class="btn btn-outline-light btn-sm"><i
					class="fa fa-thumbs-o-up"></i><span class="like-counter"><%=ld.countLikeOnPost(p.getpId())%></span></a>
				<a href="#" class="btn btn-outline-light btn-sm"><i
					class="fa fa-commenting-o"></i><span>10</span></a>
			</div>
		</div>

	</div>

	<%
	}
	%>
</div>
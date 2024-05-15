package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.ant.BaseRedirectorHelperTask;
import org.apache.catalina.manager.JspHelper;

import com.entities.Message;
import com.entities.Post;
import com.model.User;
import com.techblog.dao.PostDao;
import com.techblog.helper.ConnectionProvider;
import com.techblog.helper.Helper;

@MultipartConfig
public class PostServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		int cid = Integer.parseInt(request.getParameter("cid"));
		String pTitle = request.getParameter("pTitle");
		String pContent = request.getParameter("pContent");
		String pCode = request.getParameter("pCode");
		Part part = request.getPart("pPic");

		/* getting current user id */
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");

		Post p = new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid, user.getId());
		PostDao dao = new PostDao(ConnectionProvider.getConnection());
		if (dao.savePost(p)) {

			String path = request.getRealPath("/") + "blog-pics" + File.separator + part.getSubmittedFileName();
			Helper.saveFile(part.getInputStream(), path);

			 out.println("done");
		} else {
			out.println("error");
		}

	}

}

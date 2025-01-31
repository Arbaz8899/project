package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techblog.dao.LikeDao;
import com.techblog.helper.ConnectionProvider;

public class LikeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		String operation = request.getParameter("operation");
		int uid = Integer.parseInt(request.getParameter("uid"));
		int pid = Integer.parseInt(request.getParameter("pid"));

		
		/*
		 * out.println("data from server"); out.println(operation); out.println(uid);
		 * out.println(pid);
		 */
		 

		LikeDao ldao = new LikeDao(ConnectionProvider.getConnection());
		if (operation.equals("like")) {
			boolean f = ldao.insertLike(pid, uid);
			out.println(f);
		}

	}

}

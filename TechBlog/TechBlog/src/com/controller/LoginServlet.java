package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Message;
import com.model.User;
import com.techblog.dao.UserDao;
import com.techblog.helper.ConnectionProvider;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		
		// Login
		// fetch username and password from request
		
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		User u = dao.getUserByEmailAndPassword(userEmail, userPassword);
		
		if(u == null) {
			// Login error
			//out.println("Invalid Details...try again");
			Message msg = new Message("Invalid Details..! try again ", "error", "alert-danger");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
			response.sendRedirect("login-page.jsp");
		}else {
			// Login success
			HttpSession s = request.getSession();
			s.setAttribute("currentUser", u);
			response.sendRedirect("profile.jsp");
		}
	}

}

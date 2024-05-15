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

public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		// fetch all data

		String userName = request.getParameter("name");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");

		// get user from the user

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		user.setName(userName);
		user.setEmail(userEmail);
		user.setPassword(userPassword);

		// update database

		UserDao userDao = new UserDao(ConnectionProvider.getConnection());

		boolean ans = userDao.updateUser(user);
		if (ans) {
			out.println("updated to db");
			Message msg = new Message("Profile details updated...", "success", "alert-success");
			s.setAttribute("msg", msg);
		} else {
			out.println("not updated...");
			Message msg = new Message("Something went wrong..!", "error", "alert-danger");
			s.setAttribute("msg", msg);
		}

		response.sendRedirect("profile.jsp");

	}

}

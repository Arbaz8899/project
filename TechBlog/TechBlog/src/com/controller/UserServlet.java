package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Message;
import com.model.User;
import com.techblog.dao.UserDao;
import com.techblog.helper.ConnectionProvider;

@MultipartConfig
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		String box = request.getParameter("check");
		if (box == null) {
			out.println("Box not checked");
			Message msg = new Message("Please accept terms and conditions ", "error", "alert-danger");
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
			response.sendRedirect("register-page.jsp");
		} else {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");

			// create user object and set all data to that object
			User user = new User(name, email, password, gender);

			// create user dao object
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			if (dao.saveUser(user)) {
				out.println("Registered Successfully");
				Message msg = new Message("Registered successfully.. ", "success", "alert-success");
				HttpSession s = request.getSession();
				s.setAttribute("msg", msg);
				response.sendRedirect("register-page.jsp");
			} else {
				out.println("Error");
				/*
				 * Message msg = new Message("Invalid Details..! try again ", "error",
				 * "alert-danger"); HttpSession s = request.getSession(); s.setAttribute("msg",
				 * msg); response.sendRedirect("register-page.jsp");
				 */
			}

		}

	}

}

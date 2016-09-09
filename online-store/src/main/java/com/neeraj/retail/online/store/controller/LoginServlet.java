package com.neeraj.retail.online.store.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeraj.retail.online.store.business.service.AuthenticationBusinessService;
import com.neeraj.retail.online.store.business.service.UserBusinessService;
import com.neeraj.retail.online.store.business.service.impl.AuthenticationBusinessServiceImpl;
import com.neeraj.retail.online.store.business.service.impl.UserBusinessServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		AuthenticationBusinessService authenticationBusinessService = new AuthenticationBusinessServiceImpl();
		UserBusinessService userService = new UserBusinessServiceImpl();
		if (authenticationBusinessService.authenticate(userId, password)) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("LandingPage.jsp");
			request.setAttribute("user", userService.getUser(userId));
			requestDispatcher.forward(request, response);
		} else
			response.getWriter().write("Login Unsucessful");

	}

}

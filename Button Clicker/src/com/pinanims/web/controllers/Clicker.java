package com.pinanims.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Clicker
 */
@WebServlet("/Clicker")
public class Clicker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clicker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String cnt = session.getAttribute("cnt").toString();
        String str = "You have clicked this button " + cnt +" times";
    	request.setAttribute("str", str);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/clicker.jsp");
    	view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        int cnt = (int) session.getAttribute("cnt");
        System.out.println("cnt is currently "+cnt);
        if(session.getAttribute("cnt")!= null) {cnt ++;}        
        session.setAttribute("cnt", cnt);
        doGet(request,response);
	}

}

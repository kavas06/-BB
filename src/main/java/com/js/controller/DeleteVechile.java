package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.VechileCRUD;
@WebServlet(value="/delete1")


public class DeleteVechile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VechileCRUD bc=new VechileCRUD();
		if(bc.DeleteVechileById(Integer.parseInt(req.getParameter("id")))>0) {
		RequestDispatcher rd=req.getRequestDispatcher("view");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
		req.setAttribute("msg", "THERE IS NO VECHILE IN THESE ID");
		rd.forward(req, resp);
	}
	}
	}



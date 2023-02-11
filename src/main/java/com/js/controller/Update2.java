package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.VechileCRUD;
import com.js.dto.Vechile;
@WebServlet(value="/update2")


public class Update2 extends HttpServlet {
@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vechile b=new Vechile();
		b.setVechileid(Integer.parseInt(req.getParameter("vid")));
		b.setVechilebrand(req.getParameter("vbrand"));
		b.setVechilename(req.getParameter("vname"));
		b.setVechiletype(req.getParameter("vtype"));
		b.setVechileprice(Integer.parseInt(req.getParameter("vprice")));
		VechileCRUD bc=new VechileCRUD();
		int result=bc.UpdateVechileById(b.getVechileid(), b);
		if(result>0 ) {
			RequestDispatcher rd=req.getRequestDispatcher("view");
			rd.forward(req, resp);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
			req.setAttribute("msg","FAILED TO UPDATE");
			rd.forward(req, resp);
		}
		}
	}


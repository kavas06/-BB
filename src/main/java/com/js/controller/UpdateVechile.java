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
@WebServlet(value="/update1")


public class UpdateVechile extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id=Integer.parseInt(req.getParameter("vid"));
			VechileCRUD bc=new VechileCRUD();
			Vechile b=bc.GetVechileById(id);
			if(b!=null) {
				RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
				req.setAttribute("vechile", b);
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
				req.setAttribute("msg","NO VECHILE WITH GIVEN ID");
				rd.forward(req, resp);
			}
			
		}
		}


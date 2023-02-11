package com.js.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.VechileCRUD;
import com.js.dto.Vechile;


@WebServlet(value="/view")
public class ViewAllVechile extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			VechileCRUD bc = new VechileCRUD();
			ArrayList<Vechile> vechiles = bc.getAllVechile();

			if (vechiles.isEmpty()) {
				RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
				req.setAttribute("msg", "NO VECHILES AVAILABLE");
				rd.forward(req, resp);

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("viewall.jsp");
				req.setAttribute("vechile", vechiles);
				rd.forward(req, resp);
			}
		}
	}


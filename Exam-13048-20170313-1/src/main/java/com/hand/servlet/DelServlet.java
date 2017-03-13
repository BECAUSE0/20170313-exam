package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.utill.DbConnection;

public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DelServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		Connection conn = null;
		PreparedStatement ps = null;
		int fId = Integer.parseInt(req.getParameter("fId"));

		String sql;
		conn = DbConnection.getInstance().makeConnection();

		// LISA
		sql = "delete from film where film_id = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fId);
			int num = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(ps);
			DbConnection.close(conn);
		}
		req.getRequestDispatcher("fileSelect.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}

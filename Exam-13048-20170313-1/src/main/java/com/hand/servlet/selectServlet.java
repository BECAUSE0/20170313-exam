package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.filmEntity;
import com.hand.utill.DbConnection;

public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<filmEntity> list = new ArrayList<filmEntity>();

		String sql;
		conn = DbConnection.getInstance().makeConnection();

		// LISA
		sql = "select f.film_id,f.title,f.description,l.`name` from film f,"
				+ "language l where 1=1 and f.language_id = l.language_id";

		try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					filmEntity film = new filmEntity();
					film.setFilm_id(rs.getInt("film_id"));
					film.setTitle(rs.getString("title"));
					film.setDesc(rs.getString("description"));
					film.setLang(rs.getString("name"));
					list.add(film);
				}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.close(rs);
			DbConnection.close(ps);
			DbConnection.close(conn);
		}
		req.setAttribute("list", list);
		req.getRequestDispatcher("fileSelect.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}

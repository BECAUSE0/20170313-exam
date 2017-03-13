package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.utill.DbConnection;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		Connection conn = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		 
		String sql;
		String name = req.getParameter("name");
		conn = DbConnection.getInstance().makeConnection();

		//LISA
		sql = "select c.customer_id from customer c where c.first_name = ?";

		try {
			if (name == null ||name == "") {
				req.setAttribute("null_msg", "用户名不能为空！");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			} else {
				ps = conn.prepareStatement(sql); 
				ps.setString(1,name);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("customer_id") != null) {
						req.getRequestDispatcher("/success.jsp").forward(req, resp);
					} else {
						req.setAttribute("error_msg", "登录失败！");
						req.getRequestDispatcher("/login.jsp").forward(req, resp);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbConnection.close(rs);
			DbConnection.close(ps);
			DbConnection.close(conn);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
    

}

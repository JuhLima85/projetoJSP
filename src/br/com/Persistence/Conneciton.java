package br.com.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conneciton {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/registerDb?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "2509";
	
	
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			e.getMessage();
			return null;
		}
		
	}
	
	public void desconectar(Connection con) {
	    try {
	        if (con != null && !con.isClosed()) {
	            con.close();
	        }
	    } catch (SQLException e) {
	        System.out.println(e);
	        e.getMessage();
	    }
	}


}

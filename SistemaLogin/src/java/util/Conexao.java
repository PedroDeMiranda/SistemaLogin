package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection conectar() throws ClassNotFoundException {
		Connection con = null;
		String url      = "jdbc:mysql://localhost:3306/sistema_login";
		String user     = "user";
		String password = "pass";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex)

		{
			System.out.println("Erro ao conectar com o banco " + ex);
		}
		return con;

	}
}

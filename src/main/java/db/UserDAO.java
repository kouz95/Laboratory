package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO {
	public Connection getConnection() {
		Connection connection = null;
		String server = "localhost:13306";
		String database = "db_name";
		String option = "?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(" !! JDBC Driver load error : " + e.getMessage());
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + option, userName, password);
			System.out.println("Successfully connected");
		} catch (SQLException e) {
			System.err.println("Connection error" + e.getMessage());
			e.printStackTrace();
		}

		return connection;
	}
}

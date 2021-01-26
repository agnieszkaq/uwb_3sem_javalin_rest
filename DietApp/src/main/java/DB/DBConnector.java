package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String URL = "jdbc:mysql://127.0.0.1:3306";
	private static String USER = "root";
	private static String PASSWORD = "";

	public static Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return conn;
	}

}

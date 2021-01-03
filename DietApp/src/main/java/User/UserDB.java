package User;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.QueryExecutor;

public class UserDB {
	static List<User> users = new ArrayList<User>();
	
	private Integer id;
	private String username;
	private String password;
	private String email;

	public UserDB() {
		try {
			ResultSet result = QueryExecutor.executeSelect("Select * from food_app.user");

			while (result.next()) {
				User user = new User();
				id = result.getInt("ID");
				username = result.getString("USERNAME");
				password = result.getString("PASSWORD");
				email = result.getString("EMAIL");

				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				users.add(user);

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}

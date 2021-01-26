package User;

import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import DB.QueryExecutor;

public class UserDB {
	private Integer id;
	private String username;
	private String password;
	private String email;
	static Map<String, User> users = new HashMap<String, User>();

	public UserDB() {
		updateUsers();
	}

	public void updateUsers() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.user");
		users.clear();
		try {
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
				users.put(user.getId().toString(), user);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static User findById(String id) {
		new UserDB();
		User user = users.get(id);
		return user;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static boolean isExistByUsername(String username) {
		new UserDB();
		boolean isExist = false;

		for (User user : users.values()) {
			if (user.getUsername().equals(username)) {
				isExist = true;
			}
		}
		return isExist;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.user where id = " + id);
	}

	public static void create(String username, String password, String email) {
		QueryExecutor.executeQuery("INSERT INTO food_app.user (username, password, email) VALUES ('" + username + "','"
				+ password + "','" + email + "')");
	}

	public static void update(String id, String username, String password, String email) {
		QueryExecutor.executeQuery("Update food_app.user SET username = '" + username + "', password = '" + password
				+ "', email = '" + email + "' where id = " + id);
	}
}

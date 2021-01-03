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
	static Map<Integer, User> users = new HashMap<Integer, User>();

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
				users.put(user.getId(), user);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static User findById(Integer id) {
		new UserDB();
		User user = users.get(id);
		return user;
	}

	private static boolean isExist(Integer id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static boolean isDeleteById(Integer id) {
		boolean isExist = isExist(id);
		if (isExist) {
			QueryExecutor.executeQuery("Delete from food_app.user where id = " + id);
			return true;
		}
		return false;
	}
}

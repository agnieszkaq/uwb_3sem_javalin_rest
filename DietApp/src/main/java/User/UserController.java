package User;

import io.javalin.http.Context;

public final class UserController {

	private UserController() {

	}

	public static void getAll(Context context) {
		System.out.println("GET ::  UserController.getAll");
		context.json(UserDB.users);
	}

	public static void getById(Context context) {
		int id = Integer.parseInt((context.pathParam("id")));
		System.out.println("GET ::  UserController.getById: " + id);

		User user = UserDB.findById(id);
		if (user == null) {
			context.html("User Not Found");
		} else
			context.json(UserDB.findById(id));
	}

	public static void deleteById(Context context) {
		int id = Integer.parseInt((context.pathParam("id")));
		System.out.println("DELETE ::  UserController.getById: " + id);

		if (UserDB.isDeleteById(id)) {
			context.html("User Deleted");
			System.err.println("User: " + id + " deleted!");
		} else {
			context.html("User Not Found");
			System.err.println("User: " + id + " not found!");
		}
	}
}

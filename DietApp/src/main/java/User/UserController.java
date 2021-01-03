package User;


import io.javalin.http.Context;

public final class UserController {

	private UserController() {}
	
	public static void getAllUsers(Context context) {
		System.out.println("GET ::  UserController.getAllUsers");
		new UserDB();
		context.json(UserDB.users);
	}
}

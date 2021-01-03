package User;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public final class UserController implements CrudHandler {

	public UserController() {
	}

	@Override
	public void getAll(Context context) {
		System.out.println("GET ::  UserController.getAll");
		context.json(UserDB.users);
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  UserController.create");
		String username = context.queryParam("username");
		String password = context.queryParam("password");
		String email = context.queryParam("email");

		if (UserDB.isExistByUsername(username)) {
			System.out.println("User: " + username + " Already Exist!");
			context.html("User Already Exist");
		} else {
			System.out.println("User: " + username + " Created");
			UserDB.create(username, password, email);
		}
	}

	@Override
	public void delete(Context context, String id) {
		System.out.println("DELETE ::  UserController.delete: " + id);

		if (UserDB.isExist(id)) {
			UserDB.deleteById(id);

			context.html("User Deleted");
			System.err.println("User: " + id + " deleted!");

		} else {
			context.html("User Not Found");
			System.err.println("User: " + id + " not found!");
		}

	}

	@Override
	public void getOne(Context context, String id) {
		System.out.println("GET ::  UserController.getOne: " + id);

		User user = UserDB.findById(id);
		if (user == null) {
			context.html("User Not Found");
		} else
			context.json(UserDB.findById(id));

	}

	@Override
	public void update(Context context, String id) {
		System.out.println("PUT ::  UserController.update: " + id);

	}
}

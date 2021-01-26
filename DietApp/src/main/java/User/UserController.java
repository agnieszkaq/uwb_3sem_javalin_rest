package User;

import Format.Format;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public final class UserController implements CrudHandler {

	public UserController() {
	}

	@Override
	public void getAll(Context context) {
		if (!context.basicAuthCredentialsExist()) {
			context.html("Need Authorization");
			
		} else {
			System.out.println("GET ::  UserController.getAll");
			Format.getFormat(context, UserDB.users);
		}
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  UserController.create");
		String username = context.queryParam("username");
		String password = context.queryParam("password");
		String email = context.queryParam("email");

		if (username.equals(null)) {
			context.html("Wrong Request");
			
		}
		if (UserDB.isExistByUsername(username)) {
			System.out.println("User: " + username + " Already Exist!");
			context.html("User Already Exist");
			
		} else {
			System.out.println("User: " + username + " Created");
			UserDB.create(username, password, email);
			System.out.println("User: " + username + " Already Exist!");
			context.html("User Created");
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

		if (!context.basicAuthCredentialsExist()) {
			context.html("Need Authorization");
			
		} else {
			System.out.println("GET ::  UserController.getOne: " + id);
			User user = UserDB.findById(id);
			
			if (user == null) {
				context.html("User Not Found");
				
			} else
				context.json(UserDB.findById(id));
		}
	}

	@Override
	public void update(Context context, String id) {
		System.out.println("PUT ::  UserController.update: " + id);

		if (!UserDB.isExist(id)) {
			System.out.println("User Not Exist!");
			context.html("User Not Exist!");
			
		} else {
			User user = UserDB.findById(id);
			String username = context.queryParam("username");
			String password = context.queryParam("password");
			String email = context.queryParam("email");
			
			if (username == null) {
				username = user.getUsername();
				
			}
			if (password == null) {
				password = user.getPassword();
				
			}
			if (email == null) {
				email = user.getEmail();
				
			}
			
			UserDB.update(id, username, password, email);
			System.out.println("User: " + username + " Updated!");
			context.html("User Updated");
		}
	}
}

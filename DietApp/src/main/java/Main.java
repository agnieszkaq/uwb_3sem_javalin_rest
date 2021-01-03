import java.sql.ResultSet;
import java.sql.SQLException;

import DB.QueryExecutor;
import DB.UpdateDatabase;
import User.UserController;
import User.UserDB;
import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		new UpdateDatabase();
		
		Javalin app = Javalin.create().start(7001);
		app.get("/", UserController::getAll);
		app.get("/users/:id", UserController::getById);
		app.delete("/users/:id", UserController::deleteById);
	
	}
}

import java.sql.ResultSet;
import java.sql.SQLException;

import DB.QueryExecutor;
import User.UserController;
import User.UserDB;
import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Javalin app = Javalin.create().start(7001);
		app.get("/", UserController::getAllUsers);
	}
}

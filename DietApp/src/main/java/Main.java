import java.sql.SQLException;
import DB.UpdateDatabase;
import User.UserController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;
public class Main {

	public static void main(String[] args) throws SQLException {
		new UpdateDatabase();
		
		Javalin app = Javalin.create().start(7001);
		app.routes(() -> {
		    crud("users/:user-id", new UserController());
		});
		
	}
}

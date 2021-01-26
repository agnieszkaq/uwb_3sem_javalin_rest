package RecipeType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;
import User.User;
import User.UserDB;

public class RecipeTypeDB {

	private Integer id;
	private String name;
	static Map<String, RecipeType> recipeTypes = new HashMap<String, RecipeType>();

	public RecipeTypeDB() {
		updateRecipeTypes();
	}

	public void updateRecipeTypes() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.recipe_type");
		recipeTypes.clear();
		try {
			while (result.next()) {
				RecipeType recipeType = new RecipeType();
				id = result.getInt("ID");
				name = result.getString("NAME");
				
				recipeType.setId(id);
				recipeType.setName(name);
				
				recipeTypes.put(recipeType.getId().toString(), recipeType);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static RecipeType findById(String id) {
		new RecipeTypeDB();
		RecipeType recipeType = recipeTypes.get(id);
		return recipeType;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.recipe_type where id = " + id);
	}

	public static void create(String name) {
		QueryExecutor.executeQuery("INSERT INTO food_app.recipe_type (name) VALUES ('" + name+ "')");
	}

	public static void update(String id, String name) {
		QueryExecutor.executeQuery("Update food_app.recipe_type SET name = '" + name + "' where id = " + id);
	}
}

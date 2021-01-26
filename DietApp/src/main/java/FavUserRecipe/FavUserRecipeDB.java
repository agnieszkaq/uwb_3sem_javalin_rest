package FavUserRecipe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;

public class FavUserRecipeDB {
	private Integer id;
	private String id_user;
	private String id_recipe;

	static Map<String, FavUserRecipe> favUserRecipeMap = new HashMap<String, FavUserRecipe>();

	public FavUserRecipeDB() {
		updateFavUserRecipes();
	}

	public void updateFavUserRecipes() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.fav_user_recipe");
		favUserRecipeMap.clear();
		try {
			while (result.next()) {
				FavUserRecipe favUserRecipe = new FavUserRecipe();
				id = result.getInt("ID");
				id_recipe = result.getString("ID_RECIPE");
				id_user = result.getString("ID_USER");

				favUserRecipe.setId(id);
				favUserRecipe.setId_recipe(id_recipe);
				favUserRecipe.setId_user(id_user);

				favUserRecipeMap.put(favUserRecipe.getId().toString(), favUserRecipe);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static FavUserRecipe findById(String id) {
		new FavUserRecipe();
		FavUserRecipe favUserRecipe = favUserRecipeMap.get(id);
		return favUserRecipe;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.fav_user_recipe where id = " + id);
	}

	public static void create(String id_user, String id_recipe) {
		QueryExecutor.executeQuery("INSERT INTO food_app.fav_user_recipe (id_user, id_recipe) VALUES ('" + id_user
				+ "','" + id_recipe + "')");
	}

	public static void update(String id, String id_user, String id_recipe) {
		QueryExecutor.executeQuery("Update food_app.fav_user_recipe SET id_user = '" + id_user + "', id_recipe = '"
				+ id_recipe + "' where id = " + id);
	}

}

package Recipe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;
import Ingredient.Ingredient;
import RecipeComment.RecipeComment;
import RecipeComment.RecipeCommentDB;

public class RecipeDB {
	private Integer id;
	private String photo_name;
	private String description;
	private String text;
	private String id_recipe_type;
	private String id_user;
	static Map<String, Recipe> recipeMap = new HashMap<String, Recipe>();

	public RecipeDB() {
		updateRecipes();
	}

	public void updateRecipes() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.recipe");
		recipeMap.clear();
		try {
			while (result.next()) {
				Recipe recipe = new Recipe();
				id = result.getInt("ID");
				text = result.getString("TEXT");
				photo_name = result.getString("PHOTO_NAME");
				id_user = result.getString("ID_USER");
				id_recipe_type = result.getString("ID_RECIPE_TYPE");
				description = result.getString("DESCRIPTION");

				recipe.setDescription(description);
				recipe.setId(id);
				recipe.setId_recipe_type(id_recipe_type);
				recipe.setId_user(id_user);
				recipe.setPhoto_name(photo_name);
				recipe.setText(text);
				recipeMap.put(recipe.getId().toString(), recipe);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Recipe findById(String id) {
		new RecipeDB();
		Recipe recipe = recipeMap.get(id);
		return recipe;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.recipe where id = " + id);
	}

	public static void create(String photo_name, String description, String text, String id_recipe_type,String id_user) {
		QueryExecutor.executeQuery("INSERT INTO food_app.recipe ( photo_name, description, text, id_recipe_type, id_user) VALUES ('"
				+ photo_name + "','" + description + "','" + text + "',  '" + id_recipe_type + "', '"+id_user+"')");
	}

	public static void update(String id, String photo_name, String description, String text, String id_recipe_type, String id_user) {
		QueryExecutor.executeQuery("Update food_app.recipe SET photo_name = '" + photo_name + "', description = '" + description
				+ "', id_recipe_type = '" + id_recipe_type + "', id_user ='" + id_user + "', text = '"+text+"' where id = " + id);
	}

}

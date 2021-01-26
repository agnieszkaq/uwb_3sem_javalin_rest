package RecipeComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import DB.QueryExecutor;

public class RecipeCommentDB {
	private Integer id;
	private String text;
	private String date;
	private String id_user;
	private String id_recipe;
	static Map<String, RecipeComment> recipeCommentMap = new HashMap<String, RecipeComment>();

	public RecipeCommentDB() {
		updateRecipeComments();
	}

	public void updateRecipeComments() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.recipe_comment");
		recipeCommentMap.clear();
		try {
			while (result.next()) {
				RecipeComment comment = new RecipeComment();
				id = result.getInt("ID");
				text = result.getString("TEXT");
				date = result.getString("DATE");
				id_user = result.getString("ID_USER");
				id_recipe = result.getString("ID_RECIPE");

				comment.setDate(date);
				comment.setId(id);
				comment.setId_recipe(id_recipe);
				comment.setId_user(id_user);
				comment.setText(text);

				recipeCommentMap.put(comment.getId().toString(), comment);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static RecipeComment findById(String id) {
		new RecipeCommentDB();
		RecipeComment comment = recipeCommentMap.get(id);
		return comment;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.recipe_comment where id = " + id);
	}

	public static void create(String text, String date, String id_user, String id_recipe) {
		QueryExecutor.executeQuery("INSERT INTO food_app.recipe_comment (text, date, id_user, id_recipe) VALUES ('"
				+ text + "','" + date + "','" + id_user + "',  '" + id_recipe + "')");
	}

	public static void update(String id, String text, String date, String id_user, String id_recipe) {
		QueryExecutor.executeQuery("Update food_app.recipe_comment SET text = '" + text + "', date = '" + date
				+ "', id_recipe = '" + id_recipe + "', id_user ='" + id_user + "' where id = " + id);
	}

}

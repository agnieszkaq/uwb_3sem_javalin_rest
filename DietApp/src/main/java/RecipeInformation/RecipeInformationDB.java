package RecipeInformation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;
import Weight.Weight;
import Weight.WeightDB;

public class RecipeInformationDB {
	

	private Integer id;
	private String vegeterian;
	private String prepare_method;
	private String prepare_time;
	private String id_recipe;
	static Map<String, RecipeInformation> recipeInformationMap = new HashMap<String, RecipeInformation>();

	public RecipeInformationDB() {
		updateRecipeInformations();
	}

	public void updateRecipeInformations() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.recipe_information");
		recipeInformationMap.clear();
		try {
			while (result.next()) {
				RecipeInformation recipeInfo = new RecipeInformation();
				id = result.getInt("ID");
				vegeterian = result.getString("VEGETERIAN");
				prepare_method = result.getString("PREPARE_METHOD");
				prepare_time = result.getString("PREPARE_TIME");
				id_recipe = result.getString("ID_RECIPE");

				
				recipeInfo.setId(id);
				recipeInfo.setId_recipe(id_recipe);
				recipeInfo.setPrepare_method(prepare_method);
				recipeInfo.setPrepare_time(prepare_time);
				recipeInfo.setVegeterian(vegeterian);
				recipeInformationMap.put(recipeInfo.getId().toString(), recipeInfo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static RecipeInformation findById(String id) {
		new RecipeInformationDB();
		RecipeInformation recipeInfo = recipeInformationMap.get(id);
		return recipeInfo;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.recipe_information where id = " + id);
	}

	public static void create(String vegeterian,  String prepare_method, String prepare_time, String id_recipe) {
		QueryExecutor.executeQuery("INSERT INTO food_app.recipe_information (vegeterian, prepare_method, prepare_time, id_recipe) VALUES ('" + vegeterian
				+ "','" + prepare_method + "','" + prepare_time + "', '"+id_recipe+"')");
	}

	public static void update(String id, String vegeterian,  String prepare_method, String prepare_time, String id_recipe) {
		QueryExecutor.executeQuery("Update food_app.recipe_information SET vegeterian = '" + vegeterian + "', prepare_method = '"
				+ prepare_method + "', prepare_time = '" + prepare_time + "', id_recipe = '"+id_recipe+"' where id = " + id);
	}


}

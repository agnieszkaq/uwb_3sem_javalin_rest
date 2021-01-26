package Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;

public class IngredientDB {
	private Integer id;
	private String name;
	private Float calories;
	private Float protein;
	private Float fat;
	private Float carb;
	private String ingredient_type;

	static Map<String, Ingredient> ingredientMap = new HashMap<String, Ingredient>();

	public IngredientDB() {
		setIngredients();
	}

	public void setIngredients() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.ingredient");
		ingredientMap.clear();
		try {
			while (result.next()) {
				Ingredient ingredient = new Ingredient();
				id = result.getInt("ID");
				name = result.getString("NAME");
				calories = result.getFloat("CALORIES");

				calories = result.getFloat("CALORIES");
				protein = result.getFloat("PROTEIN");
				fat = result.getFloat("FAT");
				carb = result.getFloat("CARB");
				ingredient_type = result.getString("INGREDIENT_TYPE");

				ingredient.setCalories(calories);
				ingredient.setCarb(carb);
				ingredient.setFat(fat);
				ingredient.setId(id);
				ingredient.setName(name);
				ingredient.setProtein(protein);
				ingredient.setIngredient_type(ingredient_type);

				ingredientMap.put(ingredient.getId().toString(), ingredient);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Ingredient findById(String id) {
		new IngredientDB();
		Ingredient ingredient = ingredientMap.get(id);
		return ingredient;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.ingredient where id = " + id);
	}

	public static void create(String name, String calories, String protein, String fat, String carb,
			String ingredient_type) {
		QueryExecutor.executeQuery("INSERT INTO food_app.ingredient "
				+ "(name, calories, protein, fat, carb, ingredient_type) " + "VALUES ('" + name + "','" + calories
				+ "','" + protein + "','" + fat + "','" + carb + "','" + ingredient_type + "')");
	}

	public static void update(String id, String name, String calories, String protein, String fat, String carb,
			String ingredient_type) {
		QueryExecutor.executeQuery("Update food_app.ingredient SET name = '" + name + "', calories = '" + calories
				+ "', protein = '" + protein + "', fat = '" + fat + "', carb = '" + carb + "', ingredient_type = '"
				+ ingredient_type + "' where id = " + id);
	}

}

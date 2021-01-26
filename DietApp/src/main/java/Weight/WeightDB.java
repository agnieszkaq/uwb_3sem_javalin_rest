package Weight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;

public class WeightDB {
	private Integer id;
	private String weight;
	private String id_ingredient;
	private String id_recipe;
	static Map<String, Weight> weights = new HashMap<String, Weight>();

	public WeightDB() {
		updateWeights();
	}

	public void updateWeights() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.weight");
		weights.clear();
		try {
			while (result.next()) {
				Weight w = new Weight();
				id = result.getInt("ID");
				weight = result.getString("WEIGHT");
				id_ingredient = result.getString("ID_INGREDIENT");
				id_recipe = result.getString("ID_RECIPE");

				w.setId(id);
				w.setId_ingredient(id_ingredient);
				w.setId_recipe(id_recipe);
				w.setWeight(weight);
				weights.put(w.getId().toString(), w);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Weight findById(String id) {
		new WeightDB();
		Weight w = weights.get(id);
		return w;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.weight where id = " + id);
	}

	public static void create(String weight, String id_ingredient2, String id_recipe2) {
		QueryExecutor.executeQuery("INSERT INTO food_app.weight (weight, id_ingredient, id_recipe) VALUES ('" + weight
				+ "','" + id_ingredient2 + "','" + id_recipe2 + "')");
	}

	public static void update(String id, String weight, String id_ingredient, String id_recipe) {
		QueryExecutor.executeQuery("Update food_app.weight SET weight = '" + weight + "', id_ingredient = '"
				+ id_ingredient + "', id_recipe = '" + id_recipe + "' where id = " + id);
	}

}

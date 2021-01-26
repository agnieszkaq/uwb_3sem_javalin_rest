package Ingredient;

import Format.Format;
import User.UserDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class IngredientController implements CrudHandler {

	public IngredientController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  IngredientController.create");
		String name = context.queryParam("name");
		String calories = context.queryParam("calories");
		String protein = context.queryParam("protein");
		String fat = context.queryParam("fat");
		String carb = context.queryParam("carb");
		String ingredient_type = context.queryParam("ingredient_type");

		if (name.equals(null)) {
			context.html("Wrong Request");
		}

		System.out.println("Ingredient: " + name + " Created");
		IngredientDB.create(name, calories, protein, fat, carb, ingredient_type);
		context.html("Ingredient Created");
	}

	@Override
	public void delete(Context context, String id) {
		System.out.println("DELETE ::  IngredientController.delete: " + id);

		if (IngredientDB.isExist(id)) {
			IngredientDB.deleteById(id);

			context.html("Ingredient Deleted");
			System.err.println("Ingredient: " + id + " deleted!");

		} else {
			context.html("Ingredient Not Found");
			System.err.println("Ingredient: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		if (!context.basicAuthCredentialsExist()) {
			context.html("Need Authorization");
		} else {
			System.out.println("GET ::  IngredientController.getAll");
			Format.getFormat(context, IngredientDB.ingredientMap);
		}
	}

	@Override
	public void getOne(Context context, String id) {
		if (!context.basicAuthCredentialsExist()) {
			context.html("Need Authorization");
		} else {
			System.out.println("GET ::  IngredientController.getOne: " + id);

			Ingredient ingredient = IngredientDB.findById(id);
			if (ingredient == null) {
				context.html("Ingredient Not Found");
			} else
				context.json(IngredientDB.findById(id));
		}

	}

	@Override
	public void update(Context context, String id) {
		System.out.println("PUT ::  IngredientController.update: " + id);

		if (!IngredientDB.isExist(id)) {
			System.out.println("Ingredient Not Exist!");
			context.html("Ingredient Not Exist!");
		} else {
			Ingredient ingredient = IngredientDB.findById(id);
			String name = context.queryParam("name");
			String calories = context.queryParam("calories");
			String protein = context.queryParam("protein");
			String fat = context.queryParam("fat");
			String carb = context.queryParam("carb");
			String ingredient_type = context.queryParam("ingredient_type");

			if (name == null) {
				name = ingredient.getName();
			}
			if (calories == null) {
				calories = ingredient.getCalories().toString();
			}
			if (protein == null) {
				protein = ingredient.getProtein().toString();
			}
			if (fat == null) {
				fat = ingredient.getFat().toString();
			}
			if (carb == null) {
				carb = ingredient.getCarb().toString();
			}
			if (ingredient_type == null) {
				ingredient_type = ingredient.getIngredient_type();
			}

			IngredientDB.update(id, name, calories, protein, fat, carb, ingredient_type);
			System.out.println("Ingredient: " + id + " Updated!");
			context.html("Ingredient Updated");
		}

	}

}

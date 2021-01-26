package Recipe;

import Format.Format;
import RecipeComment.RecipeComment;
import RecipeComment.RecipeCommentDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class RecipeController implements CrudHandler {
	public RecipeController() {
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  Recipe.create");
		String photo_name = context.queryParam("photo_name");
		String description = context.queryParam("description");
		String text = context.queryParam("text");
		String id_recipe_type = context.queryParam("id_recipe_type");
		String id_user = context.queryParam("id_user");
		RecipeDB.create(photo_name, description, text, id_recipe_type, id_user);
		context.html("Recipe Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  RecipeController.delete: " + id);

		if (RecipeDB.isExist(id)) {
			RecipeDB.deleteById(id);
			context.html("Recipe Deleted");
			System.err.println("Recipe: " + id + " deleted!");

		} else {
			context.html("Recipe Not Found");
			System.err.println("Recipe: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  RecipeController.getAll");
		Format.getFormat(context, RecipeDB.recipeMap);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  RecipeController.getOne: " + id);
		Recipe recipe = RecipeDB.findById(id);

		if (recipe == null) {
			context.html("Recipe Not Found");

		} else
			context.json(RecipeDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  RecipeController.update: " + id);

		if (!RecipeDB.isExist(id)) {
			System.out.println("Recipe Not Exist!");
			context.html("Recipe Not Exist!");

		} else {
			Recipe recipe = RecipeDB.findById(id);

			String photo_name = context.queryParam("photo_name");
			String description = context.queryParam("description");
			String text = context.queryParam("text");
			String id_recipe_type = context.queryParam("id_recipe_type");
			String id_user = context.queryParam("id_user");

			if (text == null) {
				text = recipe.getText();
			}
			if (photo_name == null) {
				photo_name = recipe.getPhoto_name();
			}
			if (id_user == null) {
				id_user = recipe.getId_user();
			}
			if (id_recipe_type == null) {
				id_recipe_type = recipe.getId_recipe_type();
			}
			if (description == null) {
				description = recipe.getDescription();
			}

			RecipeDB.update(id, photo_name, description, text, id_recipe_type, id_user);
			System.out.println("Recipe Updated!");
			context.html("Recipe Updated");
		}

	}
}
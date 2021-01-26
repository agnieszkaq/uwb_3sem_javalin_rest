package FavUserRecipe;

import Format.Format;
import ForumComment.ForumComment;
import ForumComment.ForumCommentDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class FavUserRecipeController implements CrudHandler {
	public FavUserRecipeController() {
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::   FavUserRecipe.create");
		String id_recipe = context.queryParam("id_recipe");
		String id_user = context.queryParam("id_user");
		FavUserRecipeDB.create(id_user, id_recipe);
		context.html(" FavUserRecipe Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  FavUserRecipe.delete: " + id);

		if (FavUserRecipeDB.isExist(id)) {
			FavUserRecipeDB.deleteById(id);
			context.html("FavUserRecipe Deleted");
			System.err.println("FavUserRecipe: " + id + " deleted!");

		} else {
			context.html("FavUserRecipe Not Found");
			System.err.println("FavUserRecipe: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  FavUserRecipe.getAll");
		Format.getFormat(context, FavUserRecipeDB.favUserRecipeMap);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  FavUserRecipe.getOne: " + id);
		FavUserRecipe favUserRecipe = FavUserRecipeDB.findById(id);

		if (favUserRecipe == null) {
			context.html("FavUserRecipe Not Found");

		} else
			context.json(FavUserRecipeDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  FavUserRecipe.update: " + id);

		if (!FavUserRecipeDB.isExist(id)) {
			System.out.println("FavUserRecipe Not Exist!");
			context.html("FavUserRecipe Not Exist!");

		} else {
			FavUserRecipe favUserRecipe = FavUserRecipeDB.findById(id);

			String id_recipe = context.queryParam("id_recipe");
			String id_user = context.queryParam("id_user");

			if (id_user == null) {
				id_user = favUserRecipe.getId_user();
			}
			if (id_recipe == null) {
				id_recipe = favUserRecipe.getId_recipe();
			}

			FavUserRecipeDB.update(id, id_user, id_recipe);
			System.out.println("FavUserRecipe Updated!");
			context.html("FavUserRecipe Updated");
		}

	}
}

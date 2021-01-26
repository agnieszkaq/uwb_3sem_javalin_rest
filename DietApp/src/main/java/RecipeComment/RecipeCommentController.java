package RecipeComment;

import Format.Format;
import Weight.Weight;
import Weight.WeightDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class RecipeCommentController implements CrudHandler {

	public RecipeCommentController() {
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  RecipeComment.create");
		String text = context.queryParam("text");
		String date = context.queryParam("date");
		String id_user = context.queryParam("id_user");
		String id_recipe = context.queryParam("id_recipe");
		RecipeCommentDB.create(text, date, id_user, id_recipe);
		context.html("RecipeComment Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  RecipeCommentController.delete: " + id);

		if (RecipeCommentDB.isExist(id)) {
			RecipeCommentDB.deleteById(id);
			context.html("RecipeComment Deleted");
			System.err.println("RecipeComment: " + id + " deleted!");

		} else {
			context.html("RecipeComment Not Found");
			System.err.println("RecipeComment: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  RecipeCommentController.getAll");
		Format.getFormat(context, RecipeCommentDB.recipeCommentMap);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  RecipeCommentController.getOne: " + id);
		RecipeComment recipeComment = RecipeCommentDB.findById(id);

		if (recipeComment == null) {
			context.html("RecipeComment Not Found");

		} else
			context.json(RecipeCommentDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  RecipeCommentController.update: " + id);

		if (!RecipeCommentDB.isExist(id)) {
			System.out.println("RecipeComment Not Exist!");
			context.html("RecipeComment Not Exist!");

		} else {
			RecipeComment recipeComment = RecipeCommentDB.findById(id);

			String text = context.queryParam("text");
			String date = context.queryParam("date");
			String id_user = context.queryParam("id_user");
			String id_recipe = context.queryParam("id_recipe");

			if (text == null) {
				text = recipeComment.getText();

			}
			if (date == null) {
				date = recipeComment.getDate();

			}
			if (id_user == null) {
				id_user = recipeComment.getId_user();
			}
			if (id_recipe == null) {
				id_recipe = recipeComment.getId_recipe();
			}

			RecipeCommentDB.update(id, text, date, id_user, id_recipe);
			System.out.println("RecipeComment Updated!");
			context.html("RecipeComment Updated");
		}

	}
}

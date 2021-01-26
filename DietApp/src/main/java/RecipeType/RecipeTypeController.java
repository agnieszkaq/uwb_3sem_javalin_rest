package RecipeType;

import Format.Format;
import User.User;
import User.UserDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class RecipeTypeController implements CrudHandler {

	public RecipeTypeController() {
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  RecipeTypeController.create");
		String name = context.queryParam("name");

		RecipeTypeDB.create(name);
		context.html("RecipeType Created");

	}

	@Override
	public void delete(Context context, String id) {
		System.out.println("DELETE ::  RecipeTypeController.delete: " + id);

		if (RecipeTypeDB.isExist(id)) {
			RecipeTypeDB.deleteById(id);
			context.html("RecipeType Deleted");
			System.err.println("RecipeType: " + id + " deleted!");

		} else {
			context.html("RecipeType Not Found");
			System.err.println("RecipeType: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		System.out.println("GET ::  RecipeTypeController.getAll");
		Format.getFormat(context, RecipeTypeDB.recipeTypes);

	}

	@Override
	public void getOne(Context context, String id) {

		System.out.println("GET ::  UserController.getOne: " + id);
		RecipeType recipeType = RecipeTypeDB.findById(id);

		if (recipeType == null) {
			context.html("RecipeType Not Found");

		} else
			context.json(RecipeTypeDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		System.out.println("PUT ::  RecipeTypeController.update: " + id);

		if (!RecipeTypeDB.isExist(id)) {
			System.out.println("RecipeType Not Exist!");
			context.html("RecipeType Not Exist!");
			
		} else {
			RecipeType recipeType = RecipeTypeDB.findById(id);
			String name = context.queryParam("name");
			
			if (name == null) {
				name = recipeType.getName();
				
			}
			
			RecipeTypeDB.update(id, name);
			System.out.println("RecipeType: " + name + " Updated!");
			context.html("RecipeType Updated");
		}
	}

}

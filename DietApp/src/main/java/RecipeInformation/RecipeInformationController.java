package RecipeInformation;

import Format.Format;
import Weight.Weight;
import Weight.WeightDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class RecipeInformationController implements CrudHandler  {

	public RecipeInformationController() {
	}

	@Override
	public void create(Context context) {

	
		
		System.out.println("POST ::  WeightController.create");
		String vegetarian = context.queryParam("vegetarian");
		String prepare_method = context.queryParam("prepare_method");
		String  prepare_time = context.queryParam("prepare_time");
		String  id_recipe = context.queryParam("id_recipe");
		RecipeInformationDB.create(vegetarian,prepare_method,prepare_time,id_recipe);
		context.html("RecipeInformation Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  RecipeInformation.delete: " + id);

		if (RecipeInformationDB.isExist(id)) {
			RecipeInformationDB.deleteById(id);
			context.html("RecipeInformation Deleted");
			System.err.println("RecipeInformation: " + id + " deleted!");

		} else {
			context.html("RecipeInformation Not Found");
			System.err.println("RecipeInformation: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  RecipeInformation.getAll");
		Format.getFormat(context, RecipeInformationDB.recipeInformationMap);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  RecipeInformation.getOne: " + id);
		RecipeInformation recipeInformation = RecipeInformationDB.findById(id);

		if (recipeInformation == null) {
			context.html("RecipeInformation Not Found");

		} else
			context.json(RecipeInformationDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  RecipeInformation.update: " + id);

		if (!RecipeInformationDB.isExist(id)) {
			System.out.println("RecipeInformation Not Exist!");
			context.html("RecipeInformation Not Exist!");

		} else {
			RecipeInformation recipeInfo = RecipeInformationDB.findById(id);
			String vegetarian = context.queryParam("vegetarian");
			String prepare_method = context.queryParam("prepare_method");
			String prepare_time = context.queryParam("prepare_time");
			String id_recipe = context.queryParam("id_recipe");

			if (vegetarian == null) {
				vegetarian = recipeInfo.getVegeterian();

			}
			if (prepare_method == null) {
				prepare_method = recipeInfo.getPrepare_method();

			}
			if ( prepare_time == null) {
				 prepare_time = recipeInfo.getPrepare_time();

			}
			if (id_recipe == null) {
				id_recipe = recipeInfo.getId_recipe();

			}

			RecipeInformationDB.update(id, vegetarian,prepare_method,prepare_time,id_recipe);
			System.out.println("RecipeInformation Updated!");
			context.html("RecipeInformation Updated");
		}

	}


}

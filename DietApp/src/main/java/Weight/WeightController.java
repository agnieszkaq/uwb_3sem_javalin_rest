package Weight;

import Format.Format;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class WeightController implements CrudHandler {
	
	public WeightController() {
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  WeightController.create");
		String weight = context.queryParam("weight");
		String id_ingredient = context.queryParam("id_ingredient");
		String id_recipe = context.queryParam("id_recipe");
		WeightDB.create(weight, id_ingredient, id_recipe);
		context.html("Weight Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  WeightController.delete: " + id);

		if (WeightDB.isExist(id)) {
			WeightDB.deleteById(id);
			context.html("Weight Deleted");
			System.err.println("Weight: " + id + " deleted!");

		} else {
			context.html("Weight Not Found");
			System.err.println("Weight: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  WeightController.getAll");
		Format.getFormat(context, WeightDB.weights);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  WeightController.getOne: " + id);
		Weight weight = WeightDB.findById(id);

		if (weight == null) {
			context.html("Weight Not Found");

		} else
			context.json(WeightDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  WeightController.update: " + id);

		if (!WeightDB.isExist(id)) {
			System.out.println("Weight Not Exist!");
			context.html("Weight Not Exist!");

		} else {
			Weight w = WeightDB.findById(id);
			String id_recipe = context.queryParam("id_recipe");
			String weight = context.queryParam("weight");
			String id_ingredient = context.queryParam("od_ongredient");

			if (weight == null) {
				weight = w.getWeight();

			}
			if (id_ingredient == null) {
				id_ingredient = w.getId_ingredient();

			}
			if (id_recipe == null) {
				id_recipe = w.getId_recipe();

			}

			WeightDB.update(id, weight, id_ingredient, id_recipe);
			System.out.println("Weight Updated!");
			context.html("Weight Updated");
		}

	}

}

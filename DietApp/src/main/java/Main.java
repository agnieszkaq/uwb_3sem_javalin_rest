import java.sql.SQLException;
import DB.UpdateDatabase;
import FavUserRecipe.FavUserRecipeController;
import ForumComment.ForumCommentController;
import ForumNote.ForumNoteController;
import Ingredient.IngredientController;
import Recipe.RecipeController;
import RecipeComment.RecipeCommentController;
import RecipeInformation.RecipeInformationController;
import RecipeType.RecipeTypeController;
import User.UserController;
import Weight.WeightController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		new UpdateDatabase();

		Javalin app = Javalin.create().start(7000);
		app.routes(() -> {
			crud("users/:user-id", new UserController());
			crud("favuserrecipes/:favuserrecipe-id", new FavUserRecipeController());
			crud("forumcomments/:forumcomment-id", new ForumCommentController());
			crud("forumnotes/:forumnote-id", new ForumNoteController());
			crud("recipes/:recipe-id", new RecipeController());
			crud("ingredients/:ingredient-id", new IngredientController());
			crud("recipecomments/:recipecomment-id", new RecipeCommentController());
			crud("recipeinformations/:recipeinformation-id", new RecipeInformationController());
			crud("recipetypes/:recipetype-id", new RecipeTypeController());
			crud("weights/:weight-id", new WeightController());
		});

		app.error(404, ctx -> {
			ctx.html("Generic 404 message: NOT FOUND");
		});

		app.error(500, ctx -> {
			ctx.html("Generic 500 message: SERVER ERROR");
		});

		app.error(400, ctx -> {
			ctx.html("Generic 400 message: BAD REQUEST");
		});
	}
}

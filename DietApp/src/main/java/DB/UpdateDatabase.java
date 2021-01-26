package DB;

import FavUserRecipe.FavUserRecipe;
import FavUserRecipe.FavUserRecipeDB;
import ForumComment.ForumCommentDB;
import ForumNote.ForumNoteDB;
import Ingredient.IngredientDB;
import Recipe.RecipeDB;
import RecipeComment.RecipeCommentDB;
import RecipeInformation.RecipeInformationDB;
import User.UserDB;
import Weight.WeightDB;
import RecipeType.RecipeTypeDB;

public class UpdateDatabase {

	public UpdateDatabase() {
		new UserDB();
		new IngredientDB();
		new WeightDB();
		new RecipeTypeDB();
		new RecipeInformationDB();
		new RecipeCommentDB();
		new RecipeDB();
		new ForumNoteDB();
		new ForumCommentDB();
		new FavUserRecipeDB();
	}
}

package FavUserRecipe;

public class FavUserRecipe {

	private Integer id;
	private String id_user;
	private String id_recipe;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getId_recipe() {
		return id_recipe;
	}
	public void setId_recipe(String id_recipe) {
		this.id_recipe = id_recipe;
	}
	@Override
	public String toString() {
		return "FavUserRecipe [id=" + id + ", id_user=" + id_user + ", id_recipe=" + id_recipe + "]";
	}



}

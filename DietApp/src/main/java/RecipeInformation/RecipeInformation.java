package RecipeInformation;

public class RecipeInformation {

	private Integer id;
	private String vegeterian;
	private String prepare_method;
	private String prepare_time;
	private String id_recipe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVegeterian() {
		return vegeterian;
	}

	public void setVegeterian(String vegeterian) {
		this.vegeterian = vegeterian;
	}

	public String getPrepare_method() {
		return prepare_method;
	}

	public void setPrepare_method(String prepare_method) {
		this.prepare_method = prepare_method;
	}

	public String getPrepare_time() {
		return prepare_time;
	}

	public void setPrepare_time(String prepare_time) {
		this.prepare_time = prepare_time;
	}

	public String getId_recipe() {
		return id_recipe;
	}

	public void setId_recipe(String id_recipe) {
		this.id_recipe = id_recipe;
	}

	@Override
	public String toString() {
		return "RecipeInformation [id=" + id + ", vegeterian=" + vegeterian + ", prepare_method=" + prepare_method
				+ ", prepare_time=" + prepare_time + ", id_recipe=" + id_recipe + "]";
	}
	

}

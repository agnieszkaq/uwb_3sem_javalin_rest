package Weight;

public class Weight {

	private Integer id;
	private String weight;
	private String id_ingredient;
	private String id_recipe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getId_ingredient() {
		return id_ingredient;
	}

	public void setId_ingredient(String id_ingredient) {
		this.id_ingredient = id_ingredient;
	}

	public String getId_recipe() {
		return id_recipe;
	}

	public void setId_recipe(String id_recipe) {
		this.id_recipe = id_recipe;
	}

	@Override
	public String toString() {
		return "Weight [id=" + id + ", weight=" + weight + ", id_ingredient=" + id_ingredient + ", id_recipe="
				+ id_recipe + "]";
	}

}

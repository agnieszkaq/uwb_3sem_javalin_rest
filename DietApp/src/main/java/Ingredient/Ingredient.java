package Ingredient;

public class Ingredient {

	private Integer id;
	private String name;
	private Float calories;
	private Float protein;
	private Float fat;
	private Float carb;
	private String ingredient_type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getCalories() {
		return calories;
	}
	public void setCalories(Float calories) {
		this.calories = calories;
	}
	public Float getProtein() {
		return protein;
	}
	public void setProtein(Float protein) {
		this.protein = protein;
	}
	public Float getFat() {
		return fat;
	}
	public void setFat(Float fat) {
		this.fat = fat;
	}
	public Float getCarb() {
		return carb;
	}
	public void setCarb(Float carb) {
		this.carb = carb;
	}
	public String getIngredient_type() {
		return ingredient_type;
	}
	public void setIngredient_type(String ingredient_type) {
		this.ingredient_type = ingredient_type;
	}
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", calories=" + calories + ", protein=" + protein + ", fat="
				+ fat + ", carb=" + carb + ", ingredient_type=" + ingredient_type + "]";
	}
	

}

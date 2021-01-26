package Recipe;

public class Recipe {

	private Integer id;
	private String photo_name;
	private String description;
	private String text;
	private String id_recipe_type;
	private String id_user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId_recipe_type() {
		return id_recipe_type;
	}
	public void setId_recipe_type(String id_recipe_type) {
		this.id_recipe_type = id_recipe_type;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", photo_name=" + photo_name + ", description=" + description + ", text=" + text
				+ ", id_recipe_type=" + id_recipe_type + ", id_user=" + id_user + "]";
	}
	
	
}

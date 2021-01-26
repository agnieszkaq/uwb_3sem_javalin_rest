package ForumComment;

public class ForumComment {
	private Integer id;
	private String date;
	private String text;
	private String id_user;
	private String id_forum_note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getId_forum_note() {
		return id_forum_note;
	}
	public void setId_forum_note(String id_forum_note) {
		this.id_forum_note = id_forum_note;
	}
	@Override
	public String toString() {
		return "ForumComment [id=" + id + ", date=" + date + ", text=" + text + ", id_user=" + id_user
				+ ", id_forum_note=" + id_forum_note + "]";
	}	
}

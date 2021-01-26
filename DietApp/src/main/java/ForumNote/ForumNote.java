package ForumNote;

public class ForumNote {

	private Integer id;
	private String topic;
	private String date;
	private String content;
	private String id_user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "ForumNote [id=" + id + ", topic=" + topic + ", date=" + date + ", content=" + content + ", id_user="
				+ id_user + "]";
	}

}

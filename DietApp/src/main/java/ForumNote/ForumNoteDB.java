package ForumNote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;

public class ForumNoteDB {
	private Integer id;
	private String topic;
	private String date;
	private String content;
	private String id_user;
	static Map<String, ForumNote> forumNoteMap = new HashMap<String, ForumNote>();

	public ForumNoteDB() {
		updateForumNotes();
	}

	public void updateForumNotes() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.forum_note");
		forumNoteMap.clear();
		try {
			while (result.next()) {
				ForumNote forumNote = new ForumNote();
				id = result.getInt("ID");
				topic = result.getString("TOPIC");
				date = result.getString("DATE");
				content = result.getString("CONTENT");
				id_user = result.getString("ID_USER");

				forumNote.setContent(content);
				forumNote.setDate(date);
				forumNote.setId(id);
				forumNote.setId_user(id_user);
				forumNote.setTopic(topic);
				forumNoteMap.put(forumNote.getId().toString(), forumNote);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static ForumNote findById(String id) {
		new ForumNoteDB();
		ForumNote forumNote = forumNoteMap.get(id);
		return forumNote;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.forum_note where id = " + id);
	}

	public static void create(String topic, String date, String content, String id_user) {
		QueryExecutor.executeQuery("INSERT INTO food_app.forum_note (topic, date, content, id_user) VALUES ('" + topic
				+ "','" + date + "','" + content + "', '" + id_user + "')");
	}

	public static void update(String id, String topic, String date, String content, String id_user) {
		QueryExecutor.executeQuery("Update food_app.forum_note SET topic = '" + topic + "', date = '" + date
				+ "', content = '" + content + "', id_user ='" + id_user + "' where id = " + id);
	}

}

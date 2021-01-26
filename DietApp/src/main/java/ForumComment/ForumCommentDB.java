package ForumComment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import DB.QueryExecutor;

public class ForumCommentDB {
	private Integer id;
	private String date;
	private String text;
	private String id_user;
	private String id_forum_note;
	static Map<String, ForumComment> forumCommentMap = new HashMap<String, ForumComment>();

	public ForumCommentDB() {
		updateForumComments();
	}

	public void updateForumComments() {
		ResultSet result = QueryExecutor.executeSelect("Select * from food_app.forum_comment");
		forumCommentMap.clear();
		try {
			while (result.next()) {
				ForumComment forumComment = new ForumComment();
				id = result.getInt("ID");
				text = result.getString("TEXT");
				date = result.getString("DATE");
				id_forum_note = result.getString("ID_FORUM_NOTE");
				id_user = result.getString("ID_USER");

				forumComment.setDate(date);
				forumComment.setId(id);
				forumComment.setId_forum_note(id_forum_note);
				forumComment.setId_user(id_user);
				forumComment.setText(text);

				forumCommentMap.put(forumComment.getId().toString(), forumComment);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public static ForumComment findById(String id) {
		new ForumComment();
		ForumComment forumComment = forumCommentMap.get(id);
		return forumComment;
	}

	public static boolean isExist(String id) {
		if (findById(id) == null) {
			return false;
		}
		return true;
	}

	public static void deleteById(String id) {
		QueryExecutor.executeQuery("Delete from food_app.forum_comment where id = " + id);
	}

	public static void create(String date, String text, String id_user, String id_forum_note) {
		QueryExecutor.executeQuery("INSERT INTO food_app.forum_comment (date, text, id_user, id_forum_note) VALUES ('"
				+ date + "','" + text + "','" + id_user + "', '" + id_forum_note + "')");
	}

	public static void update(String id, String date, String text, String id_user, String id_forum_note) {
		QueryExecutor.executeQuery("Update food_app.forum_comment SET date = '" + date + "', text = '" + text
				+ "', id_user = '" + id_user + "', id_forum_note ='" + id_forum_note + "' where id = " + id);
	}

}

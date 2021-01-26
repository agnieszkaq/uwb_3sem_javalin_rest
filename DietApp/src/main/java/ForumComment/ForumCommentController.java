package ForumComment;

import Format.Format;
import ForumNote.ForumNote;
import ForumNote.ForumNoteDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class ForumCommentController implements CrudHandler {

	public ForumCommentController() {
	}

	private Integer id;
	private String date;
	private String text;
	private String id_user;
	private String id_forum_note;

	@Override
	public void create(Context context) {
		System.out.println("POST ::  ForumComment.create");
		String date = context.queryParam("date");
		String text = context.queryParam("text");
		String id_forum_note = context.queryParam("id_forum_note");
		String id_user = context.queryParam("id_user");
		ForumCommentDB.create(date, text, id_user, id_forum_note);
		context.html("ForumComment Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  ForumComment.delete: " + id);

		if (ForumCommentDB.isExist(id)) {
			ForumCommentDB.deleteById(id);
			context.html("ForumComment Deleted");
			System.err.println("ForumComment: " + id + " deleted!");

		} else {
			context.html("ForumComment Not Found");
			System.err.println("ForumComment: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  ForumComment.getAll");
		Format.getFormat(context, ForumCommentDB.forumCommentMap);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  ForumComment.getOne: " + id);
		ForumComment forumComment = ForumCommentDB.findById(id);

		if (forumComment == null) {
			context.html("ForumComment Not Found");

		} else
			context.json(ForumCommentDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  ForumComment.update: " + id);

		if (!ForumCommentDB.isExist(id)) {
			System.out.println("ForumComment Not Exist!");
			context.html("ForumComment Not Exist!");

		} else {
			ForumComment forumComment = ForumCommentDB.findById(id);

			String text = context.queryParam("text");
			String date = context.queryParam("date");
			String id_forum_note = context.queryParam("id_forum_note");
			String id_user = context.queryParam("id_user");

			if (text == null) {
				text = forumComment.getText();
			}
			if (date == null) {
				date = forumComment.getDate();
			}
			if (id_user == null) {
				id_user = forumComment.getId_user();
			}
			if (id_forum_note == null) {
				id_forum_note = forumComment.getId_forum_note();
			}

			ForumCommentDB.update(id, date, text, id_user, id_forum_note);
			System.out.println("ForumComment Updated!");
			context.html("ForumComment Updated");
		}

	}
}

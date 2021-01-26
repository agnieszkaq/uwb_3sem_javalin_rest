package ForumNote;

import Format.Format;
import Recipe.Recipe;
import Recipe.RecipeDB;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;

public class ForumNoteController implements CrudHandler {

	public ForumNoteController() {
	}

	@Override
	public void create(Context context) {
		System.out.println("POST ::  ForumNote.create");
		String topic = context.queryParam("topic");
		String date = context.queryParam("date");
		String content = context.queryParam("content");
		String id_user = context.queryParam("id_user");
		ForumNoteDB.create(topic, date, content, id_user);
		context.html("ForumNote Created");

	}

	@Override
	public void delete(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("DELETE ::  ForumNote.delete: " + id);

		if (ForumNoteDB.isExist(id)) {
			ForumNoteDB.deleteById(id);
			context.html("ForumNote Deleted");
			System.err.println("ForumNote: " + id + " deleted!");

		} else {
			context.html("ForumNote Not Found");
			System.err.println("ForumNote: " + id + " not found!");
		}

	}

	@Override
	public void getAll(Context context) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  ForumNote.getAll");
		Format.getFormat(context, ForumNoteDB.forumNoteMap);
	}

	@Override
	public void getOne(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("GET ::  ForumNote.getOne: " + id);
		ForumNote forumNote = ForumNoteDB.findById(id);

		if (forumNote == null) {
			context.html("ForumNote Not Found");

		} else
			context.json(ForumNoteDB.findById(id));
	}

	@Override
	public void update(Context context, String id) {
		// TODO Auto-generated method stub
		System.out.println("PUT ::  ForumNoteController.update: " + id);

		if (!ForumNoteDB.isExist(id)) {
			System.out.println("ForumNote Not Exist!");
			context.html("ForumNote Not Exist!");

		} else {
			ForumNote forumNote = ForumNoteDB.findById(id);

			String topic = context.queryParam("topic");
			String date = context.queryParam("date");
			String content = context.queryParam("content");
			String id_user = context.queryParam("id_user");

			if (topic == null) {
				topic = forumNote.getTopic();
			}
			if (date == null) {
				date = forumNote.getDate();
			}
			if (id_user == null) {
				id_user = forumNote.getId_user();
			}
			if (content == null) {
				content = forumNote.getContent();
			}

			ForumNoteDB.update(id, topic, date, content, id_user);
			System.out.println("ForumNote Updated!");
			context.html("ForumNote Updated");
		}

	}
}
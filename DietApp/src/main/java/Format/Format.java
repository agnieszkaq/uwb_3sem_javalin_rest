package Format;
import java.util.Map;

import io.javalin.http.Context;

public class Format {

	public Format() {
	}

	public static Context getFormat(Context context, Map<?, ?> map) {
		String format;
		if (context.header("format") == null) {
			format = "html";
		} else {
			format = context.header("format");
		}
		if (format.equals("json")) {
			return context.json(map);
		} else
	    return context.html(map.toString());
	}
}

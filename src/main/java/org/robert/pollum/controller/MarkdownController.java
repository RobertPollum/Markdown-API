import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

/**
 * REST class for handling API with markdown article actions. 
 */
@Path("markdown")
public class MarkdownController {
	
	@GET
	@Path("/{id}")
	public String getExistingMarkdownArticle(@PathParam("id") UUID id) {
		return "###MARKDOWN";
	}
	
}
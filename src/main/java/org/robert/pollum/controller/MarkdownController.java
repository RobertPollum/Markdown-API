package org.robert.pollum.controller;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.robert.pollum.entity.MarkdownArticle;
import org.robert.pollum.service.MarkdownService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * REST class for handling API with markdown article actions. 
 */
@Path("markdown")
public class MarkdownController implements MarkdownControllerInterface {
	
	@Inject
	MarkdownService markdownService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MarkdownArticle getExistingMarkdownArticle(@PathParam("id") UUID id) {
		return markdownService.getMarkdownArticle(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public MarkdownArticle createMarkdownArticle(@RequestBody MarkdownArticle article) {
		return markdownService.createMarkdownArticle(article);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public MarkdownArticle upMarkdownArticle(@RequestBody MarkdownArticle article) {
		return markdownService.updateMarkdownArticle(article);
	}

	@DELETE
	@Path("/{id}")
	public Boolean deleteMarkdownArticle(@PathParam("id") UUID id) {
		return markdownService.deleMarkdownArticle(id);
	}
	
}
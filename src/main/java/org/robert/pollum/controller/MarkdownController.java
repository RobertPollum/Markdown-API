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

import org.jboss.logging.Logger;


/**
 * REST class for handling API with markdown article actions. 
 */
@Path("markdown")
public class MarkdownController implements MarkdownControllerInterface {
	
	private static final Logger logger = Logger.getLogger(MarkdownController.class);

	@Inject
	MarkdownService markdownService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MarkdownArticle getExistingMarkdownArticle(@PathParam("id") Integer id) {
		return markdownService.getMarkdownArticle(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public MarkdownArticle createMarkdownArticle(@RequestBody MarkdownArticle article) {
		logger.debug(article);
		return markdownService.createMarkdownArticle(article);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public MarkdownArticle upMarkdownArticle(@RequestBody MarkdownArticle article) {
		return markdownService.updateMarkdownArticle(article);
	}

	@DELETE
	@Path("/{id}")
	public Boolean deleteMarkdownArticle(@PathParam("id") Integer id) {
		return markdownService.deleMarkdownArticle(id);
	}
	
}
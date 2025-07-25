package org.robert.pollum.service;

import java.util.Optional;
import org.robert.pollum.entity.MarkdownArticle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MarkdownService {
	
	public MarkdownArticle getMarkdownArticle(Integer id) {
		Optional<MarkdownArticle> optional = MarkdownArticle.findByIdOptional(id.toString());
		optional.orElseThrow(() -> new NotFoundException(String.format("No Markdown Article found with ID: %s", id.toString())));
		return optional.get();
	}

	public MarkdownArticle createMarkdownArticle(MarkdownArticle article) {
		if(article.getId() != null) {
			throw new IllegalArgumentException("No ID can be provided when creating a new Markdown Article");
		}
		validateMarkdownArticle(article);
		article.persist();
		return getMarkdownArticle(article.getId());
	}

	public MarkdownArticle updateMarkdownArticle(MarkdownArticle article) {
		//TODO try with resources on updating an existing markdown article if it exists
		// if it doesn't throw a NotFound exception. 
		// try()
		validateMarkdownArticle(article);
		return new MarkdownArticle();
	}

	public Boolean deleMarkdownArticle(Integer id) {
		if(MarkdownArticle.findByIdOptional(id).isEmpty()) {
			throw new NotFoundException(String.format("No Markdown Article found with id: %d", id));
		} 
		return MarkdownArticle.deleteById(id);
	}

	private void validateMarkdownArticle(MarkdownArticle article) {
		//TODO Implement validation logic in this funciton or do some of this through hibernate;
		return;
	}
}
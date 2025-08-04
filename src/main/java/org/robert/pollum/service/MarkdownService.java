package org.robert.pollum.service;

import java.util.Optional;
import java.util.UUID;

import org.robert.pollum.entity.MarkdownArticle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MarkdownService {
	
	public MarkdownArticle getMarkdownArticle(UUID id) {
		Optional<MarkdownArticle> optional = MarkdownArticle.findByIdOptional(id.toString());
		optional.orElseThrow(() -> new NotFoundException(String.format("No Markdown Article found with ID: %s", id.toString())));
		return optional.get();
	}

	@Transactional
	public MarkdownArticle createMarkdownArticle(MarkdownArticle article) {
		if(article.getId() != null) {
			throw new IllegalArgumentException("No ID can be provided when creating a new Markdown Article");
		}
		validateMarkdownArticle(article);
		article.persist();
		return getMarkdownArticle(article.getId());
	}

	@Transactional
	public MarkdownArticle updateMarkdownArticle(MarkdownArticle article) {
		//TODO try with resources on updating an existing markdown article if it exists
		// if it doesn't throw a NotFound exception. 
		// try()
		validateMarkdownArticle(article);
		return new MarkdownArticle();
	}

	@Transactional
	public Boolean deleMarkdownArticle(UUID id) {
		if(MarkdownArticle.findByIdOptional(id).isEmpty()) {
			throw new NotFoundException(String.format("No Markdown Article found with id: %d", id));
		} 
		return MarkdownArticle.deleteById(id);
	}

	private void validateMarkdownArticle(MarkdownArticle article) {
		//TODO Implement validation logic in this funciton or do some of this through hibernate;
	}
}
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
}
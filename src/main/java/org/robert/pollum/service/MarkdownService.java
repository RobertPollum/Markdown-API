package org.robert.pollum.service;

import java.util.UUID;

import org.robert.pollum.entity.MarkdownArticle;

public class MarkdownService {
	
	public MarkdownArticle getMarkdownArticle(UUID id) {
		return MarkdownArticle.getById(id);
	}
}
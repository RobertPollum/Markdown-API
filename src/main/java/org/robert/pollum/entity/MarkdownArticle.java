package org.robert.pollum.entity;

import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="markdown_article")
public class MarkdownArticle extends PanacheEntityBase {
	@Column
	UUID id;
	
	@Column
	String title;
	
	@Column
	String markdown;
	
	@Column 
	String author;
	
	public static MarkdownArticle getById(UUID id) {
		return MarkdownArticle.find("id = ?", id);
	}
}
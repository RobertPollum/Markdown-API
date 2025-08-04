package org.robert.pollum.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="markdown_article")
public class MarkdownArticle extends PanacheEntityBase {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;
	
	@Column
	private String title;
	
	@Column
	private String markdown;
	
	@Column(name="author_id")
	private Integer authorId = null;
}
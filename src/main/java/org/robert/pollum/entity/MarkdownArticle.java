package org.robert.pollum.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="markdown_article")
public class MarkdownArticle extends PanacheEntityBase {
	@Id
	@Column
	Integer id;
	
	@Column
	String title;
	
	@Column
	String markdown;
	
	@Column 
	String author;

}
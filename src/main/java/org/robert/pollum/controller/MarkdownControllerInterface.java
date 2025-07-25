package org.robert.pollum.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.robert.pollum.entity.MarkdownArticle;

import jakarta.ws.rs.PathParam;

public interface MarkdownControllerInterface {

    public MarkdownArticle getExistingMarkdownArticle(@PathParam("id") Integer id);

    public MarkdownArticle createMarkdownArticle(@RequestBody MarkdownArticle article);

    public MarkdownArticle upMarkdownArticle(@RequestBody MarkdownArticle article);

    public Boolean deleteMarkdownArticle(@PathParam("id") Integer id);
}

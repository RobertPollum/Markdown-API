package org.robert.pollum.controller;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.robert.pollum.entity.MarkdownArticle;

import jakarta.ws.rs.PathParam;

@OpenAPIDefinition(
        tags={
            @Tag(name="markdown", description = "Markdown entry operations")
        },
        info = @Info(
            title = "Markdown API",
            version = "1.0.0"
        )
    )
public interface MarkdownControllerInterface {

    
    @APIResponse(
        responseCode = "200",
        description = "Markdown Article object",
        content = {
            @Content( 
                mediaType = "application/json", 
                schema = @Schema(implementation = MarkdownArticle.class)
        )
    })
    public MarkdownArticle getExistingMarkdownArticle(@PathParam("id") UUID id);

    @APIResponse(
        responseCode = "200",
        description = "Markdown Article object",
        content = {
            @Content( 
                mediaType = "application/json", 
                schema = @Schema(implementation = MarkdownArticle.class)
        )
    })
    public MarkdownArticle createMarkdownArticle(@RequestBody MarkdownArticle article);

    @APIResponse(
        responseCode = "200",
        description = "Markdown Article object",
        content = {
            @Content( 
                mediaType = "application/json", 
                schema = @Schema(implementation = MarkdownArticle.class)
        )
    })
    public MarkdownArticle upMarkdownArticle(@RequestBody MarkdownArticle article);

    @APIResponse(
        responseCode = "202",
        description = "",
        content = {
            @Content( 
                mediaType = "application/json", 
                schema = @Schema(implementation = Boolean.class)
        )
    })
    public Boolean deleteMarkdownArticle(@PathParam("id") UUID id);
}

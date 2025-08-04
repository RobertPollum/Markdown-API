package org.robert.pollum.service;

import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
class MarkdownResourceTest {

    @Test
    void testCreateEndpoint() {
        // JsonObject markdownObject = Json.createObjectBuilder()
        // .add("id", null)
        // .add("title", "test")
        // .add("markdown", "**bold**")
        // .add("author", null);
        String parameters = """
            {
                "id": null,
                "title": "test",
                "markdown": "**bold**",
                "author": null
            }
            """;
        
        // String.format(, UUID.randomUUID().toString(), UUID.randomUUID().toString());

      given().body(parameters).header("Content-Type", "application/json")
          .when().post("/markdown"
          ).then()
          .statusCode(200)
          .body(notNullValue());
    }

}
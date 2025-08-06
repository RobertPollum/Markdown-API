package org.robert.pollum.service;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
class MarkdownResourceTest {

    @Test
    void testCreateEndpoint() {
        String parameters = """
            {
                "id": null,
                "title": "test",
                "markdown": "**bold**",
                "author": null
            }
            """;
        
        given().body(parameters).header("Content-Type", "application/json")
          .when().post("/markdown"
          ).then()
          .statusCode(200)
          .body("id", notNullValue());
    }

}
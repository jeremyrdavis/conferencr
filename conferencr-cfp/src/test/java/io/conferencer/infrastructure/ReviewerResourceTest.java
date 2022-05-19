package io.conferencer.infrastructure;

import io.conferencer.domain.Reviewer;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ReviewerResourceTest {

    String email = "mick@theclash.com";

    @Test
    @Order(1)
    public void testCreatingReviewer() {

        String requestBody = """
                {
                    "email":"mick@theclash.com"
                }
                """;
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .and()
                        .body(requestBody)
                        .when().post("/reviewers")
                        .then()
                        .extract().response();

        assertEquals(201, response.statusCode());
        assertEquals(email, response.jsonPath().getString("email"));
    }

    @Test
    @Order(2)
    public void getSpeakers() {

        List<Reviewer> response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().get("/reviewers")
                .then()
                .extract()
                .body().as(new TypeRef<List<Reviewer>>(){});

        assertEquals(1, response.size());
        Reviewer reviewer = response.get(0);
        assertEquals(email, reviewer.getEmail());
    }

}

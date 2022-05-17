package io.conferencer.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class SessionAbstractResourceTest {

    @Test
    public void testGetAbstracts() {

        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().get("/abstracts")
                .then()
                .statusCode(200);
//                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testHelloEndpoint() {
        String requestBody = """
                {
                    "title":"An Abstract for Conferencer",
                    "slug":"This is a great abstract",
                    "body":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut eleifend mollis augue, nec vestibulum neque fermentum sit amet. Aliquam erat volutpat. Etiam ac ultrices ante. Suspendisse ornare at turpis eget imperdiet. Suspendisse viverra, elit laoreet dapibus pharetra, mauris nisl bibendum quam, eu fringilla leo nulla vitae quam. Sed egestas sed lectus vel convallis. Aliquam lacinia sagittis risus, eget interdum dolor dictum at. Aliquam cursus est ut faucibus feugiat.
                            
                            Nam mi diam, dignissim eget mi vitae, luctus viverra nisl. Etiam in erat blandit, venenatis nunc ut, ullamcorper diam. Maecenas vitae est pellentesque, posuere massa venenatis, sagittis neque. Fusce ac bibendum leo, non efficitur dui. Etiam tristique aliquam sodales. Mauris porta dignissim est, quis maximus orci eleifend non. Duis blandit blandit ipsum ac hendrerit. Donec dapibus interdum quam, sit amet ultrices nisl dictum vel. Aliquam quis mollis mauris, sed hendrerit enim. Mauris scelerisque nisl quis ligula finibus, non euismod enim dignissim.
                            
                            Etiam velit magna, fermentum tincidunt rhoncus a, pulvinar sit amet odio. Etiam a quam porttitor, placerat neque in, semper magna. Praesent malesuada velit justo, in eleifend ligula fermentum eu. Mauris aliquam, mauris non laoreet porta, sapien erat venenatis felis, quis pulvinar elit odio eu diam. Donec congue dolor et sem egestas tristique. Nulla facilisi. Aliquam lobortis ex eu nisi tempor tincidunt vitae non diam. Nullam volutpat congue pulvinar. Suspendisse tortor erat."
                }
                """;
        Response response =
            given()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .and()
                    .body(requestBody)
                .when().post("/abstracts")
                .then()
                .extract().response();

        assertEquals(201, response.statusCode());
    }

}

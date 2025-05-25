package Model;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Movies {

    String apiKey = "da1d6ba1d99e4276bbe84887d5f74131";
    String sessionId = "b6d8289bf8cafb8aa7757208fafa63b068b6a45e";
    int mediaId = 550;
    int listId = 8533156;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";
    }

    @Test
    public void getMovieDetails() {
        given()
                .queryParam("api_key", apiKey)
                .when()
                .get("/movie/" + mediaId)
                .then()
                .statusCode(200)
                .body("id", equalTo(mediaId));
    }

    @Test
    public void getListsThatMovieAddedTo() {
        given()
                .queryParam("api_key", apiKey)
                .when()
                .get("/movie/" + mediaId + "/lists")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }

    @Test
    public void addRatingToMovie() {
        String ratingBody = "{\n" +
                "  \"value\": 8.5\n" +
                "}";

        given()
                .queryParam("api_key", apiKey)
                .queryParam("session_id", sessionId)
                .contentType(ContentType.JSON)
                .body(ratingBody)
                .when()
                .post("/movie/" + mediaId + "/rating")
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(201)))
                .body("status_message", containsString("Success"));
    }

    @Test
    public void deleteRatingFromMovie() {
        given()
                .queryParam("api_key", apiKey)
                .queryParam("session_id", sessionId)
                .when()
                .delete("/movie/" + mediaId + "/rating")
                .then()
                .statusCode(200)
                .body("status_message", containsString("deleted"));
    }

    @Test
    public void addMovieToList() {
        String requestBody = "{ \"media_id\": 550 }";

        Response response = given()
                .queryParam("api_key", apiKey)
                .queryParam("session_id", sessionId)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/list/" + listId + "/add_item")
                .then()
                .statusCode(anyOf(equalTo(201)))
                .body("status_message", containsString("The item/record was updated successfully."))
                .extract().response();

        System.out.println("Add to list response:\n" + response.prettyPrint());
    }
}

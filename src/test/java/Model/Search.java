package Model;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Search {

    String apiKey = "da1d6ba1d99e4276bbe84887d5f74131";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";
    }

    @Test
    public void searchMovieByTitle() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .queryParam("query", "Inception")
                .contentType(ContentType.JSON)
                .when()
                .get("/search/movie")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Search Movie Response:\n" + response.prettyPrint());
    }

    @Test
    public void searchTvShowByName() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .queryParam("query", "Breaking Bad")
                .contentType(ContentType.JSON)
                .when()
                .get("/search/tv")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Search TV Show Response:\n" + response.prettyPrint());
    }

    @Test
    public void searchPersonByName() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .queryParam("query", "Leonardo DiCaprio")
                .contentType(ContentType.JSON)
                .when()
                .get("/search/person");
    }

    @Test
    public void searchKeyword() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .queryParam("query", "superhero")
                .contentType(ContentType.JSON)
                .when()
                .get("/search/keyword")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Search Keyword Response:\n" + response.prettyPrint());
    }
}

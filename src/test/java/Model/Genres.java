package Model;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Genres {

    String apiKey = "da1d6ba1d99e4276bbe84887d5f74131";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";
    }

    @Test
    public void getMovieGenres() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get("/genre/movie/list")
                .then()
                .statusCode(200)
                .body("genres", notNullValue())
                .body("genres.size()", greaterThan(0))
                .extract().response();

        System.out.println("Movie Genres: " + response.prettyPrint());
    }

    @Test
    public void getTVGenres() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get("/genre/tv/list")
                .then()
                .statusCode(200)
                .body("genres", notNullValue())
                .body("genres.size()", greaterThan(0))
                .extract().response();

        System.out.println("TV Genres: " + response.prettyPrint());
    }
}

package Model;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class MovieLists {

    String apiKey = "da1d6ba1d99e4276bbe84887d5f74131";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";
    }

    @Test
    public void getNowPlayingMovies() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get("/movie/now_playing")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Now Playing Movies: \n" + response.prettyPrint());
    }

    @Test
    public void getPopularMovies() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get("/movie/popular")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Popular Movies: \n" + response.prettyPrint());
    }

    @Test
    public void getTopRatedMovies() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get("/movie/top_rated")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Top Rated Movies: \n" + response.prettyPrint());
    }

    @Test
    public void getUpcomingMovies() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get("/movie/upcoming")
                .then()
                .statusCode(200)
                .body("results", notNullValue())
                .body("results.size()", greaterThan(0))
                .extract().response();

        System.out.println("Upcoming Movies: \n" + response.prettyPrint());
    }
}

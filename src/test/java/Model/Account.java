package Model;

import Model.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class Account extends BaseTest {

    @Test
    public void getAccountDetails() {
        authSpec()
                .when()
                .get("/account")
                .then()
                .statusCode(200)
                .body("username", notNullValue());
    }

    @Test
    public void addMovieToFavorites() {
        String requestBody = "{\n" +
                "  \"media_type\": \"movie\",\n" +
                "  \"media_id\": 550,\n" +
                "  \"favorite\": true\n" +
                "}";

        authSpec()
                .body(requestBody)
                .post("/account/" + ACCOUNT_ID + "/favorite")
                .then()
                .statusCode(201)
                .body("status_message", containsString("success"));
    }

    @Test
    public void addMovieToWatchlist() {
        String requestBody = "{\n" +
                "  \"media_type\": \"movie\",\n" +
                "  \"media_id\": 11,\n" +
                "  \"watchlist\": true\n" +
                "}";

        authSpec()
                .body(requestBody)
                .post("/account/" + ACCOUNT_ID + "/watchlist")
                .then()
                .statusCode(201)
                .body("status_message", containsString("updated"));
    }

    @Test
    public void getFavoriteMovies() {
        authSpec()
                .get("/account/" + ACCOUNT_ID + "/favorite/movies")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }

    @Test
    public void getFavoriteTVShows() {
        authSpec()
                .get("/account/" + ACCOUNT_ID + "/favorite/tv")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }

    @Test
    public void getRatedMovies() {
        authSpec()
                .get("/account/" + ACCOUNT_ID + "/rated/movies")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }

    @Test
    public void getRatedTVShows() {
        authSpec()
                .get("/account/" + ACCOUNT_ID + "/rated/tv")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }

    @Test
    public void getWatchlistMovies() {
        authSpec()
                .get("/account/" + ACCOUNT_ID + "/watchlist/movies")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }

    @Test
    public void getWatchlistTVShows() {
        authSpec()
                .get("/account/" + ACCOUNT_ID + "/watchlist/tv")
                .then()
                .statusCode(200)
                .body("results", notNullValue());
    }
}

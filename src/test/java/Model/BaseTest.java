package Model;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static String API_KEY = "da1d6ba1d99e4276bbe84887d5f74131";
    protected static String SESSION_ID = "b6d8289bf8cafb8aa7757208fafa63b068b6a45e";
    protected static String BASE_URI = "https://api.themoviedb.org/3";
    protected static int ACCOUNT_ID = 20740181;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URI;
    }

    protected RequestSpecification authSpec() {
        return RestAssured.given()
                .contentType("application/json")
                .queryParam("api_key", API_KEY)
                .queryParam("session_id", SESSION_ID);
    }
}

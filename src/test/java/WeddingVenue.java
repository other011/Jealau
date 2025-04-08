package com.Jealau;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class WeddingVenue {

    @Test
    public void testGetWeddingVenuesEndpoint() {
        given()
                .when().get("/wedding-venues")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }
}
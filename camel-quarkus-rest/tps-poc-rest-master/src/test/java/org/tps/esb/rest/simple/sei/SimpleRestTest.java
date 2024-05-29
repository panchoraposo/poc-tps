package org.tps.esb.rest.simple.sei;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class SimpleRestTest {
    @Test
    void testGetTokenEndpoint() {
//        given()
//          .when().get("/cxf/simpleRest/getToken")
//          .then()
//             .statusCode(200)
//             .body(is(notNullValue()));
    }
    
    @Test
    void testSaveEndpoint() {
//        given()
//          .when().post("/cxf/simpleRest/save")
//          .then()
//             .statusCode(200)
//             .body(is(notNullValue()));
    }

}
package com.aston.aqajava.lesson16;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

class PostmanEchoTest {
    @Test
    public void get(){
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
    @Test
    public void post(){
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
    @Test
    public void put(){
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
    @Test
    public void delete(){
        RestAssured.delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

}
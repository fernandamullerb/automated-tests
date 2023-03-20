package helper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetHelper {

    //BDD Style:
    public static void consultaPublicacao(String idPublicacao) {
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParams("post", "1").
        when()
                .get("http://localhost:3000/posts/{post}").
        then()
                .body("author", is("typicode"))
                .statusCode(200);
    }

    //Non-BDD Style:
    public static ResponseOptions<Response> consultaPublicacoes(String url) throws URISyntaxException {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000/");
        builder.setContentType(ContentType.JSON);
        return RestAssured.given().spec(builder.build()).get(new URI(url));
    }

}

package helper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostHelper {

    //BDD Style:
    public static void publica() {
        HashMap<String, String> conteudoDaPublicacao = new HashMap<>();
        conteudoDaPublicacao.put("id", "2");
        conteudoDaPublicacao.put("title", "Rest-Assured Course");
        conteudoDaPublicacao.put("author", "Fernanda Müller Baldi");

        given()
                .contentType(ContentType.JSON).
        with()
                .body(conteudoDaPublicacao).
        when()
                .post("http://localhost:3000/posts").
        then()
                .body("author", is("Fernanda Müller Baldi"));
    }

    //Non-BDD Style:
    public static ResponseOptions<Response> publica(String url, HashMap<String, String> body, HashMap<String, String> pathParams) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000/");
        builder.setContentType(ContentType.JSON);
        return RestAssured.given().spec(builder.build()).pathParams(pathParams).body(body).post(url);
    }

}

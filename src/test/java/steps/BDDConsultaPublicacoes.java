package steps;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class BDDConsultaPublicacoes {

    public static void consultaPublicacao(String idPublicacao) {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(String.format("http://localhost:3000/posts/%s", idPublicacao))
        .then()
                .body("author", is("typicode"));
    }

    public static void consultaPublicacoes() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/posts")
        .then()
                .body("author", containsInAnyOrder("typicode"))
                .statusCode(200);

    }

}

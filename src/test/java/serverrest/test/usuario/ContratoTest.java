package serverrest.test.usuario;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import serverrest.BaseTest;

import static io.restassured.RestAssured.given;

public class ContratoTest extends BaseTest {

    @Test
    public void deveValidarContratoDeUsuarios() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator
                        .matchesJsonSchemaInClasspath("schemas/usuarios-schema.json"));
    }
}

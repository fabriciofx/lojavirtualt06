package serverrest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class CarrinhoTest{

    @BeforeAll
    public static void setupTest(){
        RestAssured.baseURI = "https://serverest.dev";
    }

    @Test
    public void teste01(){
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .get("usuarios/0uxuPY0cbmQhpEz1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all();

    }

    @AfterAll
    public static void aposTodosOsTestes(){
        System.out.println("Entrei no AfterAll");
    }

}

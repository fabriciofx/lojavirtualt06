package serverrest;

import com.github.javafaker.Faker;
import dto.LoginDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseTest {
        public static String TOKEN;
        public static String MSG_CADASTRO_USER_OK = "Cadastro realizado com sucesso";
        public static String MSG_EMAIL_DUPLICADO = "Este email já está sendo usado";
        public static String MSG_LOGIN_OK = "Login realizado com sucesso";
        public static String MSG_LOGIN_NOK = "Email e/ou senha inválidos";



        @BeforeAll
        public static void setup() {
            RestAssured.baseURI = "https://serverest.dev/";
        }

    public static RequestSpecification baseRequest() {
        return given().contentType(ContentType.JSON);
    }

    public static ValidatableResponse doGet(String path, int statusCode) {
        return baseRequest()
                .when()
                .get(path)
                .then()
                .statusCode(statusCode);
    }

    public static ValidatableResponse doGet(String path, int statusCode, String token) {
        return baseRequest()
                .headers("Authorization", token)
                .when()
                .get(path)
                .then()
                .statusCode(statusCode);
    }
    public static ValidatableResponse doPost(Object body, String path, int statusCode){
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(path)
                .then()
                .statusCode(statusCode);
        }
    public static String getToken(LoginDTO loginDTO){
        return doPost(loginDTO,"/login", HttpStatus.SC_OK).extract().jsonPath().get("authorization");
    }

    public Faker getFaker(){
        return new Faker();

    }
}

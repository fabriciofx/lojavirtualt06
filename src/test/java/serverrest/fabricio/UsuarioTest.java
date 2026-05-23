package serverrest.fabricio;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import serverrest.fabricio.dto.Usuario;
import serverrest.fabricio.response.BuscaUsuarioResponse;
import serverrest.fabricio.response.CadastraUsuarioResponse;
import serverrest.fabricio.response.RemoveUsuarioResponse;

public class UsuarioTest {
    @BeforeAll
    public static void setupTest(){
        RestAssured.baseURI = "https://serverest.dev";
    }

    @Test
    public void deveCriarEApagarUmUsuario() {
        final Faker faker = new Faker();
        final Usuario usuario = new Usuario(
            faker.name().fullName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            "true"
        );
        final CadastraUsuarioResponse criado = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .log().all()
            .body(usuario)
            .post("/usuarios")
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CadastraUsuarioResponse.class);
        Assertions.assertEquals(
            "Cadastro realizado com sucesso",
            criado.getMessage()
        );
        final RemoveUsuarioResponse removido = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .log().all()
            .delete("/usuarios/" + criado.get_id())
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(RemoveUsuarioResponse.class);
        Assertions.assertEquals(
            "Registro excluído com sucesso",
            removido.getMessage()
        );
    }

    @Test
    public void deveBuscarUmUsuario() {
        final Faker faker = new Faker();
        final Usuario usuario = new Usuario(
            faker.name().fullName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            "true"
        );
        final CadastraUsuarioResponse criado = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .log().all()
            .body(usuario)
            .post("/usuarios")
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CadastraUsuarioResponse.class);
        final BuscaUsuarioResponse cadastrado = RestAssured
            .given()
            .log().all()
            .get("/usuarios/" + criado.get_id())
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(BuscaUsuarioResponse.class);
        Assertions.assertEquals(cadastrado.get_id(), criado.get_id());
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .log().all()
            .delete("/usuarios/" + criado.get_id())
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK);
    }
}

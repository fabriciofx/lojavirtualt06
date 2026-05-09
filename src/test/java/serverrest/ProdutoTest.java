package serverrest;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.Random;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import serverrest.dto.Credenciais;
import serverrest.dto.Produto;
import serverrest.dto.Usuario;
import serverrest.response.CadastraProdutoResponse;
import serverrest.response.CadastraUsuarioResponse;
import serverrest.response.LoginResponse;
import serverrest.response.RemoveUsuarioResponse;

public class ProdutoTest {
    @BeforeAll
    public static void setupTest(){
        RestAssured.baseURI = "https://serverest.dev";
    }

    @Test
    public void deveCadastrarProduto() {
        final Random random = new Random();
        final Faker faker = new Faker();
        final Usuario usuario = new Usuario(
            faker.name().fullName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            "true"
        );
        final Produto produto = new Produto(
            faker.commerce().productName(),
            faker.commerce().productName(),
            random.nextInt(100, 10000),
            random.nextInt(1, 100)
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
        final Credenciais credenciais = new Credenciais(
            usuario.getEmail(),
            usuario.getPassword()
        );
        final LoginResponse login = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .log().all()
            .body(credenciais)
            .post("/login")
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(LoginResponse.class);
        Assertions.assertEquals(
            "Login realizado com sucesso",
            login.getMessage()
        );
        final CadastraProdutoResponse cadastrado = RestAssured
            .given()
            .header("Authorization", login.getAuthorization())
            .contentType(ContentType.JSON)
            .body(produto)
            .log().all()
            .post("/produtos")
            .then()
            .log().all()
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(CadastraProdutoResponse.class);
        Assertions.assertEquals(
            "Cadastro realizado com sucesso",
            cadastrado.getMessage()
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
}

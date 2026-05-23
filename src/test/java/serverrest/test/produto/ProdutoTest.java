package serverrest.test.produto;

import dto.LoginDTO;
import dto.ProdutoDTO;
import dto.UsuarioReqDTO;
import io.restassured.http.ContentType;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import serverrest.BaseTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ProdutoTest extends BaseTest {
    static UsuarioReqDTO usuarioReqDTO;
    @BeforeAll
    static void gerarMassaDados(){
        usuarioReqDTO = new UsuarioReqDTO("true");
        doPost(usuarioReqDTO,"/usuarios", HttpStatus.SC_CREATED)
                .body("message", containsString(MSG_CADASTRO_USER_OK));
        LoginDTO loginDTO = new LoginDTO(usuarioReqDTO.getEmail(), usuarioReqDTO.getPassword());
        TOKEN= getToken(loginDTO);
    }
    @Test
    public void deveListarProdutos() {
        doGet("/produtos",HttpStatus.SC_OK, TOKEN).body("produtos", not(empty()));
    }

    @Test
    public void naoDeveCadastrarProdutoSemToken() {
        String produto = "{\"nome\":\"Teclado\",\"preco\":200,\"descricao\":\"Teclado mecânico RGB\",\"quantidade\":5}";

        given()
                .contentType(ContentType.JSON)
                .body(produto)
                .when()
                .post("/produtos")
                .then()
                .statusCode(401)
                .body("message", containsString("Token de acesso ausente"));
    }

    @Test
    public void deveCadastrarProdutocomSucesso() {
        ProdutoDTO produtoDTO = new ProdutoDTO(getFaker().commerce().productName(), 20, "Faker1", 5);

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN)
                .body(produtoDTO).log().all()
                .when()
                .post("/produtos")
                .then().log().all()
                .statusCode(HttpStatus.SC_CREATED);
    }
}

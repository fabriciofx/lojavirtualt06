package serverrest.fabricio;

import com.github.javafaker.Faker;
import java.util.Random;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import serverrest.BaseTest;
import serverrest.fabricio.dto.Carrinho;
import serverrest.fabricio.dto.Credenciais;
import serverrest.fabricio.dto.ItemLine;
import serverrest.fabricio.dto.Produto;
import serverrest.fabricio.dto.Usuario;
import serverrest.fabricio.response.CadastraCarrinhoResponse;
import serverrest.fabricio.response.CadastraProdutoResponse;
import serverrest.fabricio.response.CadastraUsuarioResponse;
import serverrest.fabricio.response.CancelaCompraResponse;
import serverrest.fabricio.response.ListaCarrinhosResponse;
import serverrest.fabricio.response.LoginResponse;

public class CarrinhoTest extends BaseTest {
    static Usuario novoUsuario() {
        final Faker faker = new Faker();
        return new Usuario(
            faker.name().fullName(),
            faker.internet().emailAddress(),
            faker.internet().password(),
            "true"
        );
    }

    static Produto novoProduto() {
        final Random price = new Random();
        final Random quantity = new Random();
        final Faker faker = new Faker();
        return new Produto(
            faker.commerce().productName(),
            faker.commerce().productName(),
            price.nextInt(100, 500),
            quantity.nextInt(1, 5)
        );
    }

    static Credenciais cadastraUsuario(final Usuario usuario) {
        final CadastraUsuarioResponse response =
            doPost(usuario, "/usuarios", HttpStatus.SC_CREATED)
                .log().all()
                .extract()
                .as(CadastraUsuarioResponse.class);
        return new Credenciais(
            usuario.getEmail(),
            usuario.getPassword()
        );
    }

    static String fazLogin(final Credenciais credenciais) {
        final LoginResponse response =
            doPost(credenciais, "/login", HttpStatus.SC_OK)
                .log().all()
                .extract()
                .as(LoginResponse.class);
        return response.getAuthorization();
    }

    static String cadastraProduto(final String token, final Produto produto) {
        final CadastraProdutoResponse response =
            doPost(
                produto,
                "/produtos",
                HttpStatus.SC_CREATED,
                token
            )
                .log().all()
                .extract()
                .as(CadastraProdutoResponse.class);
        return response.get_id();
    }

    static String cadastraCarrinho(
        final String token,
        final Carrinho carrinho
    ) {
        final CadastraCarrinhoResponse response =
            doPost(
                carrinho,
                "/carrinhos",
                HttpStatus.SC_CREATED,
                token
            )
                .log().all()
                .extract()
                .as(CadastraCarrinhoResponse.class);
        return response.get_id();
    }

    @Test
    public void deveListarCarrinhos() {
        final Usuario usuario = novoUsuario();
        final Credenciais credenciais = cadastraUsuario(usuario);
        final String token = fazLogin(credenciais);
        final String produtoId1 = cadastraProduto(token, novoProduto());
        final String produtoId2 = cadastraProduto(token, novoProduto());
        final Carrinho carrinho = new Carrinho(
            new ItemLine(produtoId1, 1),
            new ItemLine(produtoId2, 1)
        );
        cadastraCarrinho(token, carrinho);
        final ListaCarrinhosResponse response = doGet(
            "/carrinhos",
            HttpStatus.SC_OK,
            token
        ).log().all()
        .extract()
        .as(ListaCarrinhosResponse.class);
        System.out.println(response.toString());
    }

    @Test
    public void deveCriarCarrinho() {
        final Random price = new Random();
        final Usuario usuario = novoUsuario();
        final Credenciais credenciais = cadastraUsuario(usuario);
        final String token = fazLogin(credenciais);
        final String produtoId1 = cadastraProduto(token, novoProduto());
        final String produtoId2 = cadastraProduto(token, novoProduto());
        final Carrinho carrinho = new Carrinho(
            new ItemLine(produtoId1, 1),
            new ItemLine(produtoId2, 1)
        );
        final CadastraCarrinhoResponse cadastrado = doPost(
            carrinho,
            "/carrinhos",
            HttpStatus.SC_CREATED,
            token
        )
        .log().all()
        .extract()
        .as(CadastraCarrinhoResponse.class);
        Assertions.assertEquals(MSG_CADASTRO_USER_OK, cadastrado.getMessage());
    }

    @Test
    public void deveConcluirCompra() {
        final Usuario usuario = novoUsuario();
        final Credenciais credenciais = cadastraUsuario(usuario);
        final String token = fazLogin(credenciais);
        final String produtoId1 = cadastraProduto(token, novoProduto());
        final String produtoId2 = cadastraProduto(token, novoProduto());
        final Carrinho carrinho = new Carrinho(
            new ItemLine(produtoId1, 1),
            new ItemLine(produtoId2, 1)
        );
        cadastraCarrinho(token, carrinho);
        final CancelaCompraResponse response = doDelete(
            "/carrinhos/concluir-compra",
            HttpStatus.SC_OK,
            token
        ).log().all()
            .extract()
            .as(CancelaCompraResponse.class);
        Assertions.assertEquals(MSG_COMPRA_CONCLUIDA, response.getMessage());
    }

    @Test
    public void deveCancelarCompra() {
        final Usuario usuario = novoUsuario();
        final Credenciais credenciais = cadastraUsuario(usuario);
        final String token = fazLogin(credenciais);
        final String produtoId1 = cadastraProduto(token, novoProduto());
        final String produtoId2 = cadastraProduto(token, novoProduto());
        final Carrinho carrinho = new Carrinho(
            new ItemLine(produtoId1, 1),
            new ItemLine(produtoId2, 1)
        );
        cadastraCarrinho(token, carrinho);
        final CancelaCompraResponse response = doDelete(
            "/carrinhos/cancelar-compra",
            HttpStatus.SC_OK,
            token
        ).log().all()
            .extract()
            .as(CancelaCompraResponse.class);
        Assertions.assertEquals(MSG_COMPRA_CANCELADA, response.getMessage());
    }
}

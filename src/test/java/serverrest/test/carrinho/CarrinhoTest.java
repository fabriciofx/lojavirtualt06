package serverrest.test.carrinho;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {

    @BeforeAll
    public static void setupTest(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void teste01(){


    }

    @AfterAll
    public static void aposTodosOsTestes(){
        System.out.println("Entrei no AfterAll");
    }

}

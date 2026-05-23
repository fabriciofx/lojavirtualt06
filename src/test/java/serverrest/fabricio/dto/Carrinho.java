package serverrest.fabricio.dto;

import java.util.Arrays;
import java.util.List;

public class Carrinho {
    private List<ItemLine> produtos;

    public Carrinho() {}

    public Carrinho(final ItemLine... produtos) {
        this.produtos = Arrays.asList(produtos);
    }

    public Carrinho(final List<ItemLine> produtos) {
        this.produtos = produtos;
    }

    public List<ItemLine> getProdutos() {
        return produtos;
    }

    public void setProdutos(final List<ItemLine> produtos) {
        this.produtos = produtos;
    }
}

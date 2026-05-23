package serverrest.fabricio.dto;

public class ProdutosDoCarrinho {
    private String idProduto;
    private int quantidade;
    private int precoUnitario;

    public ProdutosDoCarrinho() {
    }

    public ProdutosDoCarrinho(
        final String idProduto,
        final int quantidade,
        final int precoUnitario
    ) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(final String idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(final int precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ProdutosDoCarrinho{" +
            "idProduto='" + idProduto + '\'' +
            ", quantidade=" + quantidade +
            ", precoUnitario=" + precoUnitario +
            '}';
    }
}

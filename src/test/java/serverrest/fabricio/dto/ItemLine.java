package serverrest.fabricio.dto;

public class ItemLine {
    private String idProduto;
    private int quantidade;

    public ItemLine() {}

    public ItemLine(final String idProduto, final int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
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

    @Override
    public String toString() {
        return "ItemLine{" +
            "idProduto='" + idProduto + '\'' +
            ", quantidade=" + quantidade +
            '}';
    }
}

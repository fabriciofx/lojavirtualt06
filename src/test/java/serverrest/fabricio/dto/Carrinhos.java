package serverrest.fabricio.dto;

import java.util.List;

public class Carrinhos {
    private String _id;
    private String idUsuario;
    private int quantidadeTotal;
    private int precoTotal;
    private List<ProdutosDoCarrinho> produtos;

    public Carrinhos() {}

    public Carrinhos(
        final String _id,
        final String idUsuario,
        final int quantidadeTotal,
        final int precoTotal,
        final List<ProdutosDoCarrinho> produtos
    ) {
        this._id = _id;
        this.idUsuario = idUsuario;
        this.quantidadeTotal = quantidadeTotal;
        this.precoTotal = precoTotal;
        this.produtos = produtos;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(final String _id) {
        this._id = _id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(final String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(final int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(final int precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<ProdutosDoCarrinho> getProdutos() {
        return produtos;
    }

    public void setProdutos(final List<ProdutosDoCarrinho> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Carrinhos{" +
            "_id='" + _id + '\'' +
            ", idUsuario='" + idUsuario + '\'' +
            ", quantidadeTotal=" + quantidadeTotal +
            ", precoTotal=" + precoTotal +
            ", produtos=" + produtos +
            '}';
    }
}

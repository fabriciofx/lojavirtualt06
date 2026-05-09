package serverrest.dto;

public class Produto {
    private String nome;
    private String descricao;
    private int preco;
    private int quantidade;

    public Produto() {
    }

    public Produto(
        final String nome,
        final String descricao,
        final int preco,
        final int quantidade
    ) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(final int preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final int quantidade) {
        this.quantidade = quantidade;
    }
}

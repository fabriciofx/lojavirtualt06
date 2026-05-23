package serverrest.fabricio.response;

import java.util.List;
import serverrest.fabricio.dto.Carrinhos;

public class ListaCarrinhosResponse {
    private int quantidade;
    private List<Carrinhos> carrinhos;

    public ListaCarrinhosResponse() {}

    public ListaCarrinhosResponse(
        final int quantidade,
        final List<Carrinhos> carrinhos
    ) {
        this.quantidade = quantidade;
        this.carrinhos = carrinhos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Carrinhos> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(final List<Carrinhos> carrinhos) {
        this.carrinhos = carrinhos;
    }

    @Override
    public String toString() {
        return "ListaCarrinhosResponse{" +
            "quantidade=" + quantidade +
            ", carrinhos=" + carrinhos +
            '}';
    }
}

package serverrest.response;

public class BuscaUsuarioResponse {
    private String nome;
    private String email;
    private String password;
    private String administrador;
    private String _id;

    public BuscaUsuarioResponse() {
    }

    public BuscaUsuarioResponse(
        final String nome,
        final String email,
        final String password,
        final String administrador,
        final String _id
    ) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(final String administrador) {
        this.administrador = administrador;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(final String _id) {
        this._id = _id;
    }
}

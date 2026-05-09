package serverrest.dto;

public class Usuario {
    private String nome;
    private String email;
    private String password;
    private String administrador;

    public Usuario(
        final String nome,
        final String email,
        final String password,
        final String administrador
    ) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
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
}

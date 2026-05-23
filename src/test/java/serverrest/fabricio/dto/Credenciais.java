package serverrest.fabricio.dto;

public class Credenciais {
    private String email;
    private String password;

    public Credenciais() {
    }

    public Credenciais(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}

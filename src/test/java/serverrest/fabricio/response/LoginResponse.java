package serverrest.fabricio.response;

public class LoginResponse {
    private String message;
    private String authorization;

    public LoginResponse() {
    }

    public LoginResponse(final String message, final String authorization) {
        this.message = message;
        this.authorization = authorization;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(final String authorization) {
        this.authorization = authorization;
    }
}

package serverrest.response;

public class RemoveUsuarioResponse {
    private String message;

    public RemoveUsuarioResponse() {
    }

    public RemoveUsuarioResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}

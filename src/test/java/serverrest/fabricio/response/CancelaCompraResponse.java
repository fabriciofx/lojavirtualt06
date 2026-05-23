package serverrest.fabricio.response;

public class CancelaCompraResponse {
    private String message;

    public CancelaCompraResponse() {
    }

    public CancelaCompraResponse(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}

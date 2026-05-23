package serverrest.fabricio.response;

public class CadastraUsuarioResponse {
    private String message;
    private String _id;

    public CadastraUsuarioResponse() {
    }

    public CadastraUsuarioResponse(final String message, final String _id) {
        this.message = message;
        this._id = _id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(final String _id) {
        this._id = _id;
    }
}

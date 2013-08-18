package marco;

public class MarcoException extends RuntimeException {
    public MarcoException(String message) {
        super(message);
    }

    public MarcoException(Throwable cause) {
        super(cause);
    }
}

package marco.lang.exception;

public class MarcoLookUpError extends MarcoException {
    private String binding;

    public MarcoLookUpError(String binding) {
        super("Undefined binding '" + binding + "'");
        this.binding = binding;
    }
}

package marco.lang.exception;

public class LookUpError extends MarcoException {
    private String binding;

    public LookUpError(String binding) {
        super("Undefined binding '" + binding + "'");
        this.binding = binding;
    }
}

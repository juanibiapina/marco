package marco.lang.exceptions;

public class LookUpError extends MarcoException {
    private String binding;

    public LookUpError(String binding) {
        super("Undefined binding '" + binding + "'");
        this.binding = binding;
    }
}

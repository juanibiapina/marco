package marco.lang.exception;

import marco.lang.MarcoObject;

public class MarcoBindingError extends MarcoException {
    private String binding;
    private MarcoObject oldValue;

    public MarcoBindingError(String binding, MarcoObject oldValue) {
        super("Error binding to '" + binding + "'. Already defined as '" + oldValue + "'.");
        this.binding = binding;
        this.oldValue = oldValue;
    }
}

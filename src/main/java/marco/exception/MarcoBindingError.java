package marco.exception;

import marco.lang.MarcoObject;

public class MarcoBindingError extends MarcoException {
    private String binding;
    private MarcoObject newValue;
    private MarcoObject oldValue;

    public MarcoBindingError(String binding, MarcoObject newValue, MarcoObject oldValue) {
        super("Error binding '" + binding + "' to '" + newValue + "'. Already defined as '" + oldValue + "'.");
        this.binding = binding;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }
}

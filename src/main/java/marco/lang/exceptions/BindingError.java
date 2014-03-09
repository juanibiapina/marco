package marco.lang.exceptions;

import marco.lang.MarcoObject;

public class BindingError extends MarcoException {
    private String binding;
    private MarcoObject oldValue;

    public BindingError(String binding, MarcoObject oldValue) {
        super("Error binding to '" + binding + "'. Already defined as '" + oldValue + "'.");
        this.binding = binding;
        this.oldValue = oldValue;
    }
}

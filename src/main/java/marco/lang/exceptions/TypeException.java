package marco.lang.exceptions;

import marco.lang.MarcoObject;

public class TypeException extends MarcoException {
    private final Class expected;
    private final MarcoObject actualValue;

    public TypeException(Class expected, MarcoObject value) {
        super("Expected " + expected.getName() + " but got a " + value.getClass().getName());
        this.expected = expected;
        this.actualValue = value;
    }

    public Class getExpected() {
        return expected;
    }

    public MarcoObject getActual() {
        return actualValue;
    }
}

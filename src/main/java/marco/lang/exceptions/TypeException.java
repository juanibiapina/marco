package marco.lang.exceptions;

import marco.lang.MarcoObject;

public class TypeException extends MarcoException {
    private final String expected;
    private final MarcoObject actual;

    public TypeException(String expected, MarcoObject value) {
        super("Expected " + expected + " but got a " + value.getClass().getName());
        this.expected = expected;
        this.actual = value;
    }

    public String getExpected() {
        return expected;
    }

    public MarcoObject getActual() {
        return actual;
    }
}

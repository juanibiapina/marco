package marco;

public class MarcoArityError extends MarcoException {
    private int expected;
    private int actual;

    public MarcoArityError(int expected, int actual) {
        super("Wrong number of arguments. Expected: " + expected + ", got: " + actual);
        this.expected = expected;
        this.actual = actual;
    }
}

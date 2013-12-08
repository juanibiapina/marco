package marco.lang.exception;

public class ContractViolation extends MarcoException {
    private int expected;
    private int actual;

    public ContractViolation(int expected, int actual) {
        super("Wrong number of arguments. Expected: " + expected + ", got: " + actual);
        this.expected = expected;
        this.actual = actual;
    }

    public int getExpected() {
        return expected;
    }

    public int getActual() {
        return actual;
    }
}

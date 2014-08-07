package marco.lang.error;

import marco.lang.MarcoObject;

public class TypeError extends Error {
    public TypeError(Class expected, MarcoObject value, String fileName, int line) {
        super(fileName, line, "Expected " + expected.getName() + " but got a " + value.getClass().getName());
    }
}

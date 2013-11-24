package marco.lang;

import marco.exception.MarcoArityError;

public abstract class MarcoMacro extends MarcoRunnable {
    protected void assertArity(int expected, int actual) {
        if (actual != expected) {
            throw new MarcoArityError(expected, actual);
        }
    }
}

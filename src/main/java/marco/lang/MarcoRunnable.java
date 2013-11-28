package marco.lang;

import marco.internal.Environment;
import marco.lang.exception.MarcoArityError;

public abstract class MarcoRunnable extends MarcoValue {
    public abstract MarcoObject call(Environment environment, MarcoList arguments);

    protected void assertArity(int expected, int actual) {
        if (actual != expected) {
            throw new MarcoArityError(expected, actual);
        }
    }
}

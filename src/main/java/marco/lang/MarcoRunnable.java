package marco.lang;

import marco.lang.exception.MarcoArityError;
import marco.internal.Environment;

import java.util.List;

public abstract class MarcoRunnable extends MarcoValue {
    public abstract MarcoObject call(Environment environment, List<MarcoObject> arguments);

    protected void assertArity(int expected, int actual) {
        if (actual != expected) {
            throw new MarcoArityError(expected, actual);
        }
    }
}

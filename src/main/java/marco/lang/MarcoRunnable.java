package marco.lang;

import marco.lang.exception.MarcoArityError;
import marco.internal.Environment;

import java.util.List;

public abstract class MarcoRunnable extends MarcoObject {
    public abstract MarcoObject call(Environment environment, List<MarcoObject> arguments);

    @Override
    public MarcoObject eval(Environment environment) {
        return this;
    }

    protected void assertArity(int expected, int actual) {
        if (actual != expected) {
            throw new MarcoArityError(expected, actual);
        }
    }
}

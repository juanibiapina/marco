package marco.lang.helpers;

import marco.MarcoException;
import marco.lang.MarcoObject;
import marco.lang.MarcoRunnable;

public class Cast {
    public static MarcoRunnable toRunnable(MarcoObject value) {
        if (value instanceof MarcoRunnable) {
            return (MarcoRunnable) value;
        } else {
            throw new MarcoException("Expected a runnable, got a " + value.getClass().getName());
        }
    }
}

package marco.lang.helpers;

import marco.exception.MarcoTypeError;
import marco.lang.MarcoObject;
import marco.lang.MarcoRunnable;
import marco.lang.MarcoSymbol;

public class Cast {
    public static MarcoRunnable toRunnable(MarcoObject value) {
        if (value instanceof MarcoRunnable) {
            return (MarcoRunnable) value;
        } else {
            throw new MarcoTypeError(MarcoRunnable.class, value);
        }
    }

    public static MarcoSymbol toSymbol(MarcoObject value) {
        if (value instanceof MarcoSymbol) {
            return (MarcoSymbol) value;
        } else {
            throw new MarcoTypeError(MarcoSymbol.class, value);
        }
    }
}

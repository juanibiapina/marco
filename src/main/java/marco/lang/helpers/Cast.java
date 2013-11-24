package marco.lang.helpers;

import marco.exception.MarcoTypeError;
import marco.lang.*;

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

    public static MarcoList toList(MarcoForm value) {
        if (value instanceof MarcoList) {
            return (MarcoList) value;
        } else {
            throw new MarcoTypeError(MarcoList.class, value);
        }
    }

    public static MarcoNumber toNumber(MarcoForm value) {
        if (value instanceof MarcoNumber) {
            return (MarcoNumber) value;
        } else {
            throw new MarcoTypeError(MarcoNumber.class, value);
        }
    }
}

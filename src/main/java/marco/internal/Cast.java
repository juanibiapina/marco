package marco.internal;

import marco.lang.exceptions.TypeError;
import marco.lang.*;

public class Cast {
    public static MarcoRunnable toRunnable(MarcoObject value) {
        if (value instanceof MarcoRunnable) {
            return (MarcoRunnable) value;
        } else {
            throw new TypeError(MarcoRunnable.class, value);
        }
    }

    public static MarcoList toList(MarcoObject value) {
        if (value instanceof MarcoList) {
            return (MarcoList) value;
        } else {
            throw new TypeError(MarcoList.class, value);
        }
    }

    public static MarcoNumber toNumber(MarcoObject value) {
        if (value instanceof MarcoNumber) {
            return (MarcoNumber) value;
        } else {
            throw new TypeError(MarcoNumber.class, value);
        }
    }

    public static MarcoBoolean toBoolean(MarcoObject value) {
        if (value instanceof MarcoBoolean) {
            return (MarcoBoolean) value;
        } else {
            return MarcoBoolean.TRUE;
        }
    }

    public static MarcoString toString(MarcoObject value) {
        if (value instanceof MarcoString) {
            return (MarcoString) value;
        } else {
            throw new TypeError(MarcoString.class, value);
        }
    }

    public static MarcoModule toModule(MarcoObject value) {
        if (value instanceof MarcoModule) {
            return (MarcoModule) value;
        } else {
            throw new TypeError(MarcoModule.class, value);
        }
    }

    public static MarcoSymbol toSymbol(MarcoObject value) {
        if (value instanceof MarcoSymbol) {
            return (MarcoSymbol) value;
        } else {
            throw new TypeError(MarcoSymbol.class, value);
        }
    }

    public static MarcoBlock toBlock(MarcoObject value) {
        if (value instanceof MarcoBlock) {
            return (MarcoBlock) value;
        } else {
            throw new TypeError(MarcoBlock.class, value);
        }
    }
}

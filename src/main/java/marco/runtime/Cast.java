package marco.runtime;

import marco.lang.error.TypeError;
import marco.lang.exceptions.TypeException;
import marco.lang.*;

public class Cast {
    public static MarcoRunnable toRunnable(MarcoObject value, String fileName, int line) {
        if (value instanceof MarcoRunnable) {
            return (MarcoRunnable) value;
        } else {
            throw new TypeError(MarcoRunnable.class, value, fileName, line);
        }
    }

    public static MarcoNumber toNumber(MarcoObject value) {
        if (value instanceof MarcoNumber) {
            return (MarcoNumber) value;
        } else {
            throw new TypeException("Number", value);
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
            throw new TypeException("String", value);
        }
    }

    public static MarcoModule toModule(MarcoObject value) {
        if (value instanceof MarcoModule) {
            return (MarcoModule) value;
        } else {
            throw new TypeException("Module", value);
        }
    }

    public static MarcoSymbol toSymbol(MarcoObject value) {
        if (value instanceof MarcoSymbol) {
            return (MarcoSymbol) value;
        } else {
            throw new TypeException("Symbol", value);
        }
    }

    public static MarcoBlock toBlock(MarcoObject value) {
        if (value instanceof MarcoBlock) {
            return (MarcoBlock) value;
        } else {
            throw new TypeException("Block", value);
        }
    }

    public static MarcoPort toPort(MarcoObject value) {
        if (value instanceof MarcoPort) {
            return (MarcoPort) value;
        } else {
            throw new TypeException("Port", value);
        }
    }

    public static MarcoPair toPair(String expected, MarcoObject value) {
        if (value instanceof MarcoPair) {
            return (MarcoPair) value;
        } else {
            throw new TypeException(expected, value);
        }
    }

    public static MarcoHashMap toHashMap(MarcoObject value) {
        if (value instanceof MarcoHashMap) {
            return (MarcoHashMap) value;
        } else {
            throw new TypeException("HashMap", value);
        }
    }
}

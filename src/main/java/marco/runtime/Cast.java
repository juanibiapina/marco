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

    public static MarcoList toList(MarcoObject value) {
        if (value instanceof MarcoList) {
            return (MarcoList) value;
        } else {
            throw new TypeException(MarcoList.class, value);
        }
    }

    public static MarcoNumber toNumber(MarcoObject value) {
        if (value instanceof MarcoNumber) {
            return (MarcoNumber) value;
        } else {
            throw new TypeException(MarcoNumber.class, value);
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
            throw new TypeException(MarcoString.class, value);
        }
    }

    public static MarcoModule toModule(MarcoObject value) {
        if (value instanceof MarcoModule) {
            return (MarcoModule) value;
        } else {
            throw new TypeException(MarcoModule.class, value);
        }
    }

    public static MarcoSymbol toSymbol(MarcoObject value) {
        if (value instanceof MarcoSymbol) {
            return (MarcoSymbol) value;
        } else {
            throw new TypeException(MarcoSymbol.class, value);
        }
    }

    public static MarcoBlock toBlock(MarcoObject value) {
        if (value instanceof MarcoBlock) {
            return (MarcoBlock) value;
        } else {
            throw new TypeException(MarcoBlock.class, value);
        }
    }

    public static MarcoPort toPort(MarcoObject value) {
        if (value instanceof MarcoPort) {
            return (MarcoPort) value;
        } else {
            throw new TypeException(MarcoPort.class, value);
        }
    }

    public static MarcoPair toPair(MarcoObject value) {
        if (value instanceof MarcoPair) {
            return (MarcoPair) value;
        } else {
            throw new TypeException(MarcoPair.class, value);
        }
    }
}

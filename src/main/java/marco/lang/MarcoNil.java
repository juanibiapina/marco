package marco.lang;

import marco.internal.Environment;

public class MarcoNil extends MarcoObject {
    public static final MarcoObject NIL = new MarcoNil();

    private MarcoNil() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MarcoNil) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MarcoObject eval(Environment environment) {
        return this;
    }

    @Override
    public String toString() {
        return "nil";
    }

    @Override
    public String typeName() {
        return "Nil";
    }
}

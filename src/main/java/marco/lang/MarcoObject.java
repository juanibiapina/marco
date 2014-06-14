package marco.lang;

import marco.internal.Environment;

public abstract class MarcoObject {
    public abstract MarcoObject eval(Environment dynamic);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract boolean isList();

    public abstract String asString();
}

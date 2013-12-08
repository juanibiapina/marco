package marco.lang;

import marco.internal.Environment;

public abstract class MarcoObject {
    public abstract MarcoObject eval(Environment environment);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();
}

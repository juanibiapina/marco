package marco.lang;

import marco.internal.Environment;

import java.util.List;

public abstract class MarcoObject {
    public abstract MarcoObject eval(Environment environment);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract List<String> freeVariables();

    public abstract boolean isList();
}

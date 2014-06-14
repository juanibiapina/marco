package marco.lang;

import marco.internal.Environment;

public abstract class MarcoObject {
    public MarcoObject eval(Environment environment) {
        return doEval(environment, environment);
    }

    protected abstract MarcoObject doEval(Environment closure, Environment environment);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract boolean isList();

    public abstract String asString();
}

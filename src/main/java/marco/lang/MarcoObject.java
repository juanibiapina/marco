package marco.lang;

import marco.internal.Environment;

public abstract class MarcoObject {
    public MarcoObject eval(Environment environment) {
        MarcoObject result = doEval(environment, environment);
        while (result.isContinuation()) {
            result = result.doEval(environment, environment);
        }
        return result;
    }

    protected abstract MarcoObject doEval(Environment closure, Environment environment);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract boolean isList();

    public abstract boolean isContinuation();

    public abstract String asString();
}

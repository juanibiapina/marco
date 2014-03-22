package marco.lang;

import marco.internal.Environment;

import java.util.List;

public abstract class MarcoObject {
    public MarcoObject eval(Environment environment) {
        MarcoObject result = doEval(environment, environment);
        while (result.isContinuation()) {
            result = result.doEval(environment, environment);
        }
        return result;
    }

    protected abstract MarcoObject doEval(Environment environment, Environment global);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract List<String> freeVariables();

    public abstract boolean isList();

    public abstract boolean isContinuation();
}

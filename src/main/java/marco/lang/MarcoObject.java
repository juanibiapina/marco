package marco.lang;

import marco.internal.Environment;

import java.util.List;

public abstract class MarcoObject {
    public MarcoObject eval(Environment environment) {
        MarcoObject result = doEval(environment);
        while (result.isContinuation()) {
            result = result.doEval(environment);
        }
        return result;
    }

    protected abstract MarcoObject doEval(Environment environment);

    @Override
    public String toString() {
        return typeName();
    }

    public abstract String typeName();

    public abstract List<String> freeVariables();

    public abstract boolean isList();

    public abstract boolean isContinuation();
}

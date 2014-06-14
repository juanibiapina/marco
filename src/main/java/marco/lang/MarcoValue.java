package marco.lang;

import marco.internal.Environment;

public abstract class MarcoValue extends MarcoObject {
    @Override
    public MarcoObject doEval(Environment closure, Environment environment) {
        return this;
    }
}

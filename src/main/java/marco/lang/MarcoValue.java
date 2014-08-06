package marco.lang;

import marco.runtime.Environment;

public abstract class MarcoValue extends MarcoObject {
    @Override
    public MarcoObject __eval(Environment dynamic) {
        return this;
    }
}

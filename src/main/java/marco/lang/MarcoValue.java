package marco.lang;

import marco.internal.Environment;

import java.util.Collections;
import java.util.List;

public abstract class MarcoValue extends MarcoObject {
    @Override
    public MarcoObject eval(Environment environment) {
        return this;
    }

    @Override
    public List<String> freeVariables() {
        return Collections.EMPTY_LIST;
    }
}

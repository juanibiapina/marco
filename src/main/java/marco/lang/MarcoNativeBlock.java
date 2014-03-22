package marco.lang;

import marco.internal.Environment;

import java.util.Collections;
import java.util.List;

public abstract class MarcoNativeBlock extends MarcoBlock {
    public MarcoNativeBlock() {
        super(null);
    }

    @Override
    public String typeName() {
        return "NativeBlock";
    }

    @Override
    public List<String> freeVariables() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public abstract MarcoObject invoke(Environment closure, Environment environment);

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }
}

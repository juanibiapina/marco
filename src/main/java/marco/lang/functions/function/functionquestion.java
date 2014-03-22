package marco.lang.functions.function;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoFunction;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class functionquestion extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject v = closure.lookUp("v");

        return MarcoBoolean.from(v instanceof MarcoFunction);
    }
}

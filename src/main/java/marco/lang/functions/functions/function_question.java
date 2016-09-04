package marco.lang.functions.functions;

import marco.runtime.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoFunction;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class function_question extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject v = closure.lookUp("v");

        return MarcoBoolean.from(v instanceof MarcoFunction);
    }
}

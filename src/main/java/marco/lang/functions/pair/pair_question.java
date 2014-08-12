package marco.lang.functions.pair;

import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.runtime.Environment;

public class pair_question extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject value = closure.lookUp("value");

        return MarcoBoolean.from(value.isPair());
    }
}

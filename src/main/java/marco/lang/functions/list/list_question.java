package marco.lang.functions.list;

import marco.runtime.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class list_question extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject value = closure.lookUp("value");

        return MarcoBoolean.from(value.isList());
    }
}

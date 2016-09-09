package marco.lang.functions.strings;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;
import marco.runtime.Environment;

public class from extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject value = closure.lookUp("value");

        return new MarcoString(value.convertToString());
    }
}

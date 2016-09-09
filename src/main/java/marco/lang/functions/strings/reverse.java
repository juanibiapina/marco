package marco.lang.functions.strings;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;
import marco.runtime.Cast;
import marco.runtime.Environment;

public class reverse extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoString value = Cast.toString(closure.lookUp("value"));

        return new MarcoString(new StringBuilder(value.getValue()).reverse().toString());
    }
}

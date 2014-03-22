package marco.lang.functions.booleans;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class _not extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject v = closure.lookUp("e");

        MarcoBoolean b = Cast.toBoolean(v);

        return b.not();
    }
}

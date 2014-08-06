package marco.lang.functions.booleans;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class _not extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject v = closure.lookUp("e");

        MarcoBoolean b = Cast.toBoolean(v);

        return b.not();
    }
}

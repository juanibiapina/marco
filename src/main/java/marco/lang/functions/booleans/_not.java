package marco.lang.functions.booleans;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class _not extends MarcoNativeObject {
    @Override
    protected MarcoObject doEval(Environment environment, Environment global) {
        MarcoObject v = environment.lookUp("e");

        MarcoBoolean b = Cast.toBoolean(v);

        return b.not();
    }
}

package marco.lang.functions.pair;

import marco.internal.Environment;
import marco.lang.*;

public class pairquestion extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject arg = closure.lookUp("pair");

        return MarcoBoolean.from(arg instanceof MarcoPair);
    }
}

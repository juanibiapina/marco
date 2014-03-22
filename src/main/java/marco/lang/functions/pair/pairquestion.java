package marco.lang.functions.pair;

import marco.internal.Environment;
import marco.lang.*;

public class pairquestion extends MarcoNativeObject {
    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        MarcoObject arg = environment.lookUp("pair");

        return MarcoBoolean.from(arg instanceof MarcoPair);
    }
}

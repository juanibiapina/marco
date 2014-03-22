package marco.lang.functions.pair;

import marco.internal.Environment;
import marco.lang.*;

public class pairquestion extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoObject arg = environment.lookUp("pair");

        return MarcoBoolean.from(arg instanceof MarcoPair);
    }
}

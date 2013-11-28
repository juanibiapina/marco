package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.*;

public class pairquestion extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject arg = environment.lookUp("pair");

        if (arg instanceof MarcoPair) {
            return MarcoBoolean.TRUE;
        } else {
            return MarcoBoolean.FALSE;
        }
    }
}

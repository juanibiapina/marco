package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.*;

public class pairquestion extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject arg = environment.lookUp("pair");

        return MarcoBoolean.from(arg instanceof MarcoPair);
    }
}

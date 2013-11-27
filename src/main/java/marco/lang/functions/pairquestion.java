package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.*;

import java.util.List;

public class pairquestion extends MarcoNativeFunction {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(1, arguments.size());

        MarcoObject arg = arguments.get(0).eval(environment);

        if (arg instanceof MarcoPair) {
            return MarcoBoolean.TRUE;
        } else {
            return MarcoBoolean.FALSE;
        }
    }
}

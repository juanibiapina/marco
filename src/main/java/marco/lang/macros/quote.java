package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.MarcoForm;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoObject;

import java.util.List;

public class quote extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(1, arguments.size());

        MarcoObject arg = arguments.get(0);

        return arg;
    }
}

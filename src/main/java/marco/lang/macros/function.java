package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.*;
import marco.internal.Cast;

import java.util.List;

public class function extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(2, arguments.size());

        MarcoList formal = Cast.toList(arguments.get(0));
        List<String> formalList = formal.asArgumentList();

        MarcoForm body = arguments.get(1);

        return new MarcoFunction(environment, formalList, body);
    }
}

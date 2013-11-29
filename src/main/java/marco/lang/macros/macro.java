package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

import java.util.List;

public class macro extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(2, arguments.size());

        MarcoList formal = Cast.toList(arguments.get(0));
        List<String> formalList = formal.asArgumentList();

        MarcoObject body = arguments.get(1);

        return new MarcoMacro(environment, formalList, body);
    }
}

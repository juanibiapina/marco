package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.*;
import marco.lang.exception.MarcoTypeError;

import java.util.List;

public class macro extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(2, arguments.size());

        MarcoObject formal = arguments.get(0);

        if (formal instanceof MarcoList) {
            List<String> formalList = ((MarcoList) formal).asArgumentList();
            MarcoObject body = arguments.get(1);
            return new MarcoMacro(environment, formalList, body);
        }

        if (formal instanceof MarcoSymbol) {
            String arg = ((MarcoSymbol) formal).getValue();
            MarcoObject body = arguments.get(1);
            return new MarcoVariadicMacro(environment, arg, body);
        }

        throw new MarcoTypeError(MarcoList.class, formal);
    }
}

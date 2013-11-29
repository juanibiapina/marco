package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.*;
import marco.lang.exception.MarcoTypeError;

import java.util.Arrays;
import java.util.List;

public class function extends MarcoNativeMacro {
    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(2, arguments.size());

        MarcoObject formal = arguments.get(0);

        List<String> formalList = null;
        boolean variadic = false;

        if (formal instanceof MarcoList) {
            formalList = ((MarcoList)formal).asArgumentList();
        } else {
            if (formal instanceof MarcoSymbol) {
                formalList = Arrays.asList(((MarcoSymbol) formal).getValue());
                variadic = true;
            } else {
                throw new MarcoTypeError(MarcoList.class, formal);
            }
        }

        MarcoObject body = arguments.get(1);

        return new MarcoFunction(environment, formalList, body, variadic);
    }
}

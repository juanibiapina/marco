package marco.macros;

import marco.internal.Environment;
import marco.lang.*;
import marco.lang.helpers.Cast;

import java.util.List;

public class function implements MarcoMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        MarcoList formal = Cast.toList(arguments.get(0));
        List<MarcoSymbol> formalList = formal.asArgumentList();

        MarcoForm body = arguments.get(1);

        return new MarcoFunction(environment, formalList, body);
    }
}

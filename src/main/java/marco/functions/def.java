package marco.functions;

import marco.internal.Environment;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.MarcoForm;
import marco.lang.MarcoSymbol;

import java.util.List;

public class def implements MarcoMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        String name = ((MarcoSymbol) arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);
        environment.add(name, value);
        return null; // TODO
    }
}
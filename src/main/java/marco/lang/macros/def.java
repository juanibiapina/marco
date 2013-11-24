package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.MarcoForm;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.helpers.Cast;

import java.util.List;

public class def extends MarcoMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(2, arguments.size());

        String name = Cast.toSymbol(arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);

        environment.bind(name, value);

        return environment.lookUp("nil");
    }
}

package marco.macros;

import marco.MarcoArityError;
import marco.internal.Environment;
import marco.lang.MarcoForm;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.helpers.Cast;

import java.util.List;

public class def implements MarcoMacro {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArguments(2, arguments);

        String name = Cast.toSymbol(arguments.get(0)).getValue();
        MarcoObject value = arguments.get(1).eval(environment);
        environment.add(name, value);
        return environment.lookUp("nil");
    }

    private void assertArguments(int number, List<MarcoForm> arguments) {
        if (arguments.size() != number) {
            throw new MarcoArityError(number, arguments.size());
        }
    }
}

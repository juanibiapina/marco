package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoForm;
import marco.lang.MarcoNativeFunction;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

import java.util.List;

public class cons extends MarcoNativeFunction {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(2, arguments.size());

        MarcoObject first = arguments.get(0).eval(environment);
        MarcoObject second = arguments.get(1).eval(environment); // TODO: arguments need to be evaluated before this

        return new MarcoPair(first, second);
    }
}

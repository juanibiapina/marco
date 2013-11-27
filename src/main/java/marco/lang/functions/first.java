package marco.lang.functions;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoForm;
import marco.lang.MarcoNativeFunction;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

import java.util.List;

public class first extends MarcoNativeFunction {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(1, arguments.size());

        MarcoPair pair = Cast.toPair(arguments.get(0).eval(environment));

        return pair.getFirst();
    }
}

package marco.lang.functions;

import marco.internal.Environment;
import marco.internal.NativeFunction;
import marco.lang.MarcoForm;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;
import marco.lang.helpers.Cast;

import java.util.List;

public class plus extends NativeFunction {
    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(2, arguments.size());

        MarcoNumber n1 = Cast.toNumber(arguments.get(0));
        MarcoNumber n2 = Cast.toNumber(arguments.get(1));

        return new MarcoNumber(n1.getValue() + n2.getValue());
    }
}

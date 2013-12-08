package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;
import marco.lang.contracts.Contract;

import java.util.List;

public class macro extends MarcoNativeMacro {
    public macro() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoList formal = Cast.toList(arguments.get(0));
        List<String> formalList = formal.asArgumentList();

        MarcoObject body = arguments.get(1);

        return new MarcoMacro(environment, formalList, body);
    }
}

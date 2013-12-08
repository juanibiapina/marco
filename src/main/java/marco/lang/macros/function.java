package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.*;
import marco.internal.Cast;
import marco.lang.contracts.Contract;

import java.util.List;

public class function extends MarcoNativeMacro {
    public function() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        assertArity(2, arguments.size());

        MarcoList formal = Cast.toList(arguments.get(0));
        List<String> formalList = formal.asArgumentList();

        MarcoObject body = arguments.get(1);

        return new MarcoFunction(environment, formalList, body);
    }
}

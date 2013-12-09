package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class let extends MarcoNativeMacro {
    public let() {
        super(new Contract(2));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoList list = Cast.toList(arguments.get(0));

        String name = Cast.toSymbol(list.get(0)).getValue();
        MarcoObject value = list.get(1).eval(environment);

        MarcoObject body = arguments.get(1);

        Environment extendedEnv = environment.duplicate();
        extendedEnv.let(name, value);

        return body.eval(extendedEnv);
    }
}

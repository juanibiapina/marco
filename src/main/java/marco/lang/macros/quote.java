package marco.lang.macros;

import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoNativeMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class quote extends MarcoNativeMacro {
    public quote() {
        super(new Contract(1));
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject arg = arguments.get(0);

        return arg;
    }
}

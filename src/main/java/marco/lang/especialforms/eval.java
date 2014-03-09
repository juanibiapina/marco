package marco.lang.especialforms;

import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class eval extends MarcoMacro {
    public eval() {
        super(new Contract(1));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoObject arg = arguments.get(0);

        return arg.eval(environment).eval(environment);
    }
}

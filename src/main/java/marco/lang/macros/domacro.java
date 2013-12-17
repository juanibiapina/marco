package marco.lang.macros;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoList;
import marco.lang.MarcoMacro;
import marco.lang.MarcoObject;
import marco.lang.contracts.Contract;

public class domacro extends MarcoMacro {
    public domacro() {
        super(new Contract(1));
    }

    @Override
    protected MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        MarcoList es = Cast.toList(arguments.get(0));

        MarcoObject result = null;
        for (int i = 0; i < es.size(); i++) {
            result = es.get(i).eval(environment);
        }

        return result;
    }
}

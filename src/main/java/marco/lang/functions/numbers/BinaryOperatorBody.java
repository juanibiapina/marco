package marco.lang.functions.numbers;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public abstract class BinaryOperatorBody extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoNumber v1 = Cast.toNumber(environment.lookUp("v1"));
        MarcoNumber v2 = Cast.toNumber(environment.lookUp("v2"));

        return doEval(v1, v2);
    }

    protected abstract MarcoObject doEval(MarcoNumber v1, MarcoNumber v2);
}

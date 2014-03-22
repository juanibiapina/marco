package marco.lang.functions.number;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;

public abstract class BinaryOperatorBody extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoNumber v1 = Cast.toNumber(closure.lookUp("v1"));
        MarcoNumber v2 = Cast.toNumber(closure.lookUp("v2"));

        return invoke(v1, v2);
    }

    protected abstract MarcoObject invoke(MarcoNumber v1, MarcoNumber v2);
}

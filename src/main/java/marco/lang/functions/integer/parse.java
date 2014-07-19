package marco.lang.functions.integer;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;

public class parse extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoString value = Cast.toString(closure.lookUp("value"));

        return new MarcoNumber(Integer.parseInt(value.getValue()));
    }
}

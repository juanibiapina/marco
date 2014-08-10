package marco.lang.functions.integer;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNumber;
import marco.lang.MarcoObject;
import marco.lang.MarcoString;

import java.math.BigInteger;

public class parse extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoString value = Cast.toString(closure.lookUp("value"));

        return new MarcoNumber(new BigInteger(value.getValue()));
    }
}

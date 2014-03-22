package marco.lang.functions.pair;

import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

public class cons extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment environment) {
        MarcoObject first = closure.lookUp("first");
        MarcoObject second = closure.lookUp("second");

        return new MarcoPair(first, second);
    }
}

package marco.lang.functions.pair;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;
import marco.runtime.Environment;

public class pair extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject e1 = closure.lookUp("e1");
        MarcoObject e2 = closure.lookUp("e2");

        return new MarcoPair(e1, e2);
    }
}

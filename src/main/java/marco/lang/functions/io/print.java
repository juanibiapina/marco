package marco.lang.functions.io;

import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class print extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject v = closure.lookUp("e");

        System.out.println(v);

        return MarcoNil.NIL;
    }
}

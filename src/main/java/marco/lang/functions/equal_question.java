package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class equal_question extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject e1 = closure.lookUp("e1");
        MarcoObject e2 = closure.lookUp("e2");

        return MarcoBoolean.from(e1.equals(e2));
    }
}

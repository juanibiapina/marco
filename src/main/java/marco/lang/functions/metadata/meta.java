package marco.lang.functions.metadata;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.runtime.Environment;

public class meta extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject object = closure.lookUp("object");

        return object.getMetadata();
    }
}

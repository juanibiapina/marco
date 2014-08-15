package marco.lang.functions.metadata;

import marco.lang.MarcoHashMap;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.runtime.Cast;
import marco.runtime.Environment;

public class with_meta extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject object = closure.lookUp("object");
        MarcoHashMap data = Cast.toHashMap(closure.lookUp("data"));

        return object.withMeta(data);
    }
}

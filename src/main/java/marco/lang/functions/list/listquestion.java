package marco.lang.functions.list;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class listquestion extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoObject value = environment.lookUp("value");

        return MarcoBoolean.from(value.isList());
    }
}

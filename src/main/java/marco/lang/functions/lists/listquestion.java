package marco.lang.functions.lists;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class listquestion extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject value = environment.lookUp("value");

        return MarcoBoolean.from(value.isList());
    }
}

package marco.lang.functions.list;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class listquestion extends MarcoNativeObject {
    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        MarcoObject value = environment.lookUp("value");

        return MarcoBoolean.from(value.isList());
    }
}

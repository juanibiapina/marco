package marco.lang.functions.function;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoFunction;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class functionquestion extends MarcoNativeObject {
    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        MarcoObject v = environment.lookUp("v");

        return MarcoBoolean.from(v instanceof MarcoFunction);
    }
}

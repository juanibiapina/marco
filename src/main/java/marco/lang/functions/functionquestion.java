package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoFunction;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoObject;

public class functionquestion extends MarcoNativeObject {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject v = environment.lookUp("v");

        return MarcoBoolean.from(v instanceof MarcoFunction);
    }
}

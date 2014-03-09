package marco.lang.functions.nil;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeObject;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class nilquestion extends MarcoNativeObject {
    @Override
    public MarcoObject doEval(Environment environment) {
        MarcoObject arg = environment.lookUp("arg");

        return MarcoBoolean.from(arg instanceof MarcoNil);
    }
}

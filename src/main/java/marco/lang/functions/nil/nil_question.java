package marco.lang.functions.nil;

import marco.runtime.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class nil_question extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoObject arg = closure.lookUp("arg");

        return MarcoBoolean.from(arg instanceof MarcoNil);
    }
}

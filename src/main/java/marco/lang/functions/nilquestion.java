package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoBoolean;
import marco.lang.MarcoNativeForm;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;

public class nilquestion extends MarcoNativeForm {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject arg = environment.lookUp("arg");

        if (arg instanceof MarcoNil) {
            return MarcoBoolean.TRUE;
        } else {
            return MarcoBoolean.FALSE;
        }
    }
}

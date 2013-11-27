package marco.lang.functions;

import marco.internal.Environment;
import marco.lang.MarcoNativeForm;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

public class cons extends MarcoNativeForm {
    @Override
    public MarcoObject eval(Environment environment) {
        MarcoObject first = environment.lookUp("first");
        MarcoObject second = environment.lookUp("second");

        return new MarcoPair(first, second);
    }
}

package marco.lang.functions.pair;

import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;

public class cons extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment environment) {
        MarcoObject first = environment.lookUp("first");
        MarcoObject second = environment.lookUp("second");

        return new MarcoPair(first, second);
    }
}

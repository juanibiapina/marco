package marco.lang.functions.pair;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPair;
import marco.runtime.Cast;
import marco.runtime.Environment;

public class second extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoPair pair = Cast.toPair(closure.lookUp("pair"));

        return pair.getSecond();
    }
}

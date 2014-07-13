package marco.lang.functions.io;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoPort;
import marco.lang.MarcoString;

public class read_line extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoPort in = Cast.toPort(closure.lookUp("in"));

        return new MarcoString(in.readLine());
    }
}

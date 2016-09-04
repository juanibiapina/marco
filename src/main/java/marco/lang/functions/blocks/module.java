package marco.lang.functions.blocks;

import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.MarcoBlock;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoObject;

public class module extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoBlock block = Cast.toBlock(closure.lookUp("block"));

        return dynamic.getRuntime().module(block);
    }
}

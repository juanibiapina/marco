package marco.lang.functions.module;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;

public class export extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoSymbol symbol = Cast.toSymbol(closure.lookUp("symbol"));

        dynamic.getModule().export(symbol.getValue(), dynamic.lookUp(symbol.getValue()));

        return MarcoNil.NIL;
    }
}

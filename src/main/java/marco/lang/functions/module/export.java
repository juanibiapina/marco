package marco.lang.functions.module;

import marco.internal.Cast;
import marco.internal.Environment;
import marco.lang.*;

public class export extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        MarcoList symbols = Cast.toList(closure.lookUp("symbols"));

        for (int i = 0; i < symbols.length(); i++) {
            MarcoSymbol symbol = Cast.toSymbol(symbols.get(i));
            dynamic.getModule().export(symbol.getValue(), dynamic.lookUp(symbol.getValue()));
        }

        return MarcoNil.NIL;
    }
}

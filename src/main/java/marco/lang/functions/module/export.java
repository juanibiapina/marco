package marco.lang.functions.module;

import marco.lang.MarcoNativeBlock;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.MarcoSymbol;
import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.runtime.ListHelper;

import java.util.List;

public class export extends MarcoNativeBlock {
    @Override
    public MarcoObject invoke(Environment closure, Environment dynamic) {
        List<MarcoObject> symbols = ListHelper.toJavaList(closure.lookUp("symbols"));

        for (MarcoObject psymbol : symbols) {
            MarcoSymbol symbol = Cast.toSymbol(psymbol);
            dynamic.getModule().export(symbol.getValue(), dynamic.lookUp(symbol.getValue()));
        }

        return MarcoNil.NIL;
    }
}

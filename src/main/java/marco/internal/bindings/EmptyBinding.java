package marco.internal.bindings;

import marco.lang.MarcoObject;
import marco.lang.exception.LookUpError;
import marco.lang.exception.MarcoException;

public class EmptyBinding extends Binding {
    public EmptyBinding(String symbol) {
        super(symbol, null);
    }

    @Override
    public void mutate(MarcoObject value) {
        throw new MarcoException("bug");
    }

    @Override
    public MarcoObject getValue() {
        throw new LookUpError(getSymbol());
    }
}

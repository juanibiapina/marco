package marco.internal.bindings;

import marco.lang.MarcoObject;
import marco.lang.exceptions.LookUpError;

public class EmptyBinding extends Binding {
    public EmptyBinding(String name) {
        super(name, null);
    }

    @Override
    public void mutate(MarcoObject value) {
        throw new LookUpError(getSymbol());
    }
}

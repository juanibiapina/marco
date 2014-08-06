package marco.runtime.bindings;

import marco.lang.MarcoObject;
import marco.lang.exceptions.ImmutabilityError;

public class ImmutableBinding extends Binding {
    public ImmutableBinding(String var, MarcoObject value) {
        super(var, value);
    }

    @Override
    public void mutate(MarcoObject value) {
        throw new ImmutabilityError(this);
    }
}

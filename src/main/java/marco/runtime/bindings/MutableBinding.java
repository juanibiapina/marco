package marco.runtime.bindings;

import marco.lang.MarcoObject;

public class MutableBinding extends Binding {
    public MutableBinding(String var, MarcoObject value) {
        super(var, value);
    }

    @Override
    public void mutate(MarcoObject value) {
        setValue(value);
    }
}

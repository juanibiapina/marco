package marco.internal.bindings;

import marco.lang.MarcoObject;

public class LetBinding extends ImmutableBinding {
    public LetBinding(String name, MarcoObject value) {
        super(name, value);
    }
}

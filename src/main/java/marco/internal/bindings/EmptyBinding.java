package marco.internal.bindings;

import marco.lang.MarcoObject;

public class EmptyBinding extends Binding {
    public EmptyBinding(String name) {
        super(name, null);
    }

    @Override
    public void mutate(MarcoObject value) {
        throw new RuntimeException("Mutation of empty binding. Should not happen.");
    }
}

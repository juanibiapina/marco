package marco.internal;

import marco.internal.bindings.Binding;
import marco.lang.exceptions.LookUpError;

public class Slot {
    private String name;
    private Binding binding;

    public Slot(String name, Binding binding) {
        this.name = name;
        this.binding = binding;
    }

    public Slot(String name) {
        this.name = name;
        this.binding = null;
    }

    public Binding getBinding() {
        if (binding == null) {
            throw new LookUpError(name);
        }
        return binding;
    }

    public boolean isEmpty() {
        return binding == null;
    }

    public void setBinding(Binding binding) {
        this.binding = binding;
    }
}

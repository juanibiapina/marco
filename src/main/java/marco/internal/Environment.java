package marco.internal;

import marco.internal.bindings.Binding;
import marco.internal.bindings.ImmutableBinding;
import marco.internal.bindings.MutableBinding;
import marco.lang.MarcoObject;
import marco.lang.exceptions.BindingError;
import marco.lang.exceptions.LookUpError;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Slot> slots = new HashMap<>();
    private final Environment parent;

    public Environment() {
        parent = null;
    }

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public void def(String name, MarcoObject value) {
        addBinding(new ImmutableBinding(name, value));
    }

    public void var(String name, MarcoObject value) {
        addBinding(new MutableBinding(name, value));
    }

    public MarcoObject lookUp(String var) {
        if (slots.containsKey(var)) {
            return slots.get(var).getBinding().getValue();
        } else {
            if (hasParent()) {
                return parent.lookUp(var);
            } else {
                throw new LookUpError(var);
            }
        }
    }

    public Environment duplicate() {
        Map<String, Slot> newEnvMap = new HashMap<>();
        newEnvMap.putAll(slots);
        Environment newEnv = new Environment(this);
        newEnv.slots = newEnvMap;
        return newEnv;
    }

    public Binding get(String name) {
        if (slots.containsKey(name)) {
            return slots.get(name).getBinding();
        } else {
            if (hasParent()) {
                return parent.get(name);
            } else {
                throw new LookUpError(name);
            }
        }
    }

    public void addSlot(Binding binding) {
        slots.put(binding.getSymbol(), new Slot(binding.getSymbol(), binding));
    }

    public Environment spawn() {
        return new Environment(this);
    }

    private boolean hasParent() {
        return parent != null;
    }

    private void addBinding(Binding binding) {
        String name = binding.getSymbol();

        if (hasBinding(name)) {
            throw new BindingError(name, lookUp(name));
        }

        slots.put(name, new Slot(name, binding));
    }

    private boolean hasBinding(String name) {
        if (slots.containsKey(name)) {
            return true;
        } else {
            if (hasParent()) {
                return parent.hasBinding(name);
            } else {
                return false;
            }
        }
    }
}

package marco.internal;

import marco.internal.bindings.Binding;
import marco.internal.bindings.ImmutableBinding;
import marco.internal.bindings.MutableBinding;
import marco.lang.MarcoObject;
import marco.lang.exceptions.BindingError;
import marco.lang.exceptions.LookUpError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    private Map<String, Slot> slots = new HashMap<>();

    public Environment() {
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
            throw new LookUpError(var);
        }
    }

    public Environment duplicate() {
        Map<String, Slot> newEnvMap = new HashMap<>();
        newEnvMap.putAll(slots);
        Environment newEnv = new Environment();
        newEnv.slots = newEnvMap;
        return newEnv;
    }

    public Environment filter(List<String> vars) {
        Environment result = new Environment();

        for (String var : vars) {
            Slot slot = slots.get(var);
            if (slot == null) {
                slot = new Slot(var);
            }
            result.slots.put(var, slot);
        }

        return result;
    }

    public Binding get(String name) {
        if (slots.containsKey(name)) {
            return slots.get(name).getBinding();
        } else {
            throw new LookUpError(name);
        }
    }

    public void addSlot(Binding binding) {
        slots.put(binding.getSymbol(), new Slot(binding.getSymbol(), binding));
    }

    private void addBinding(Binding binding) {
        String name = binding.getSymbol();

        if (slots.containsKey(name)) {
            Slot slot = slots.get(name);
            if (slot.isEmpty()) {
                slot.setBinding(binding);
            } else {
                throw new BindingError(name, slot.getBinding().getValue());
            }
        } else {
            slots.put(name, new Slot(name, binding));
        }
    }
}

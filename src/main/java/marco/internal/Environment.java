package marco.internal;

import marco.internal.bindings.*;
import marco.lang.MarcoObject;
import marco.lang.exceptions.BindingError;
import marco.lang.error.LookUpError;
import marco.runtime.MarcoRuntime;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Binding> bindings = new HashMap<>();
    private final Environment parent;
    private MarcoRuntime runtime;

    public Environment(MarcoRuntime runtime) {
        this.runtime = runtime;
        parent = null;
    }

    public Environment(Environment parent) {
        this.parent = parent;
        this.runtime = parent.runtime;
    }

    public void def(String name, MarcoObject value) {
        addBinding(new ImmutableBinding(name, value));
    }

    public void var(String name, MarcoObject value) {
        addBinding(new MutableBinding(name, value));
    }

    public void let(String name, MarcoObject value) {
        addLocalBinding(new LetBinding(name, value));
    }

    public void parameter(String name, MarcoObject value) {
        addLocalBinding(new ParameterBinding(name, value));
    }

    public MarcoObject lookUp(String var) {
        if (bindings.containsKey(var)) {
            return bindings.get(var).getValue();
        } else {
            if (hasParent()) {
                return parent.lookUp(var);
            } else {
                throw new LookUpError(runtime, null, -1, var); // Bug in Marco?
            }
        }
    }

    public Binding get(String name) {
        if (bindings.containsKey(name)) {
            return bindings.get(name);
        } else {
            if (hasParent()) {
                return parent.get(name);
            } else {
                return new EmptyBinding(name);
            }
        }
    }

    public Environment spawn() {
        return new Environment(this);
    }

    private void addLocalBinding(Binding binding) {
        bindings.put(binding.getSymbol(), binding);
    }

    private void addBinding(Binding binding) {
        String name = binding.getSymbol();

        if (hasBinding(name)) {
            throw new BindingError(name, lookUp(name));
        }

        bindings.put(name, binding);
    }

    private boolean hasBinding(String name) {
        if (bindings.containsKey(name)) {
            return true;
        } else {
            if (hasParent()) {
                return parent.hasBinding(name);
            } else {
                return false;
            }
        }
    }

    private boolean hasParent() {
        return parent != null;
    }

    public MarcoObject stack(Frame frame) {
        return runtime.stack(frame);
    }

    public MarcoRuntime getRuntime() {
        return runtime;
    }
}

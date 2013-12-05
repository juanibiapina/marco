package marco.internal;

import marco.lang.MarcoObject;
import marco.lang.exception.MarcoBindingError;
import marco.lang.exception.MarcoLookUpError;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Binding> env = new HashMap<>();

    public Environment() {
    }

    public void bind(String var, MarcoObject value) {
        if (env.containsKey(var)) {
            throw new MarcoBindingError(var, value, env.get(var).getValue());
        } else {
            env.put(var, new ImmutableBinding(var, value));
        }
    }

    public void bindVar(String var, MarcoObject value) {
        if (env.containsKey(var)) {
            throw new MarcoBindingError(var, value, env.get(var).getValue());
        } else {
            env.put(var, new MutableBinding(var, value));
        }
    }

    public void rebind(String var, MarcoObject value) {
        env.put(var, new ImmutableBinding(var, value));
    }

    public void mutate(String var, MarcoObject value) {
        Binding b = env.get(var);
        b.mutate(value);
    }

    public MarcoObject lookUp(String var) {
        if (env.containsKey(var)) {
            return env.get(var).getValue();
        } else {
            throw new MarcoLookUpError(var);
        }
    }

    public Environment duplicate() {
        Map newEnvMap = new HashMap();
        newEnvMap.putAll(env);
        Environment newEnv = new Environment();
        newEnv.env = newEnvMap;
        return newEnv;
    }
}

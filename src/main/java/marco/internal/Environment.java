package marco.internal;

import marco.lang.MarcoBoolean;
import marco.lang.MarcoNil;
import marco.lang.MarcoObject;
import marco.lang.exception.MarcoBindingError;
import marco.lang.exception.MarcoLookUpError;
import marco.lang.functions.*;
import marco.lang.macros.def;
import marco.lang.macros.function;
import marco.lang.macros.setbang;
import marco.lang.macros.var;

import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Binding> env = new HashMap<>();

    public Environment() {
        bind("def", new def());
        bind("function", new function());
        bind("nil", MarcoNil.NIL);
        bind("+", new plus());
        bind("true", MarcoBoolean.TRUE);
        bind("false", MarcoBoolean.FALSE);
        bind("var", new var());
        bind("set!", new setbang());
        bind("cons", new cons());
        bind("first", new first());
        bind("second", new second());
        bind("nil?", new nilquestion());
        bind("pair?", new pairquestion());
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
        Map newEnv = new HashMap();
        newEnv.putAll(env);
        return new Environment(newEnv);
    }

    private Environment(Map env) {
        this.env = env;
    }
}

package marco.internal;

import marco.lang.*;
import marco.lang.exception.MarcoBindingError;
import marco.lang.exception.MarcoLookUpError;
import marco.lang.functions.*;
import marco.lang.macros.*;
import marco.parser.Parser;

import java.util.Arrays;
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

    public static Environment initial() {
        Environment environment = new Environment();

        environment.bind("macro", new macro());
        environment.bind("function", new function());
        environment.bind("if", new ifmacro());

        environment.bind("quote", new quote());

        environment.bind("nil", MarcoNil.NIL);
        environment.bind("true", MarcoBoolean.TRUE);
        environment.bind("false", MarcoBoolean.FALSE);

        environment.bind("def", new def());
        environment.bind("var", new var());
        environment.bind("set!", new setbang());

        environment.bind("parse", new MarcoFunction(environment, Arrays.asList("code"), new parse(Parser.instance())));
        environment.bind("eval", new MarcoFunction(environment, Arrays.asList("arg"), new eval()));

        environment.bind("cons", new MarcoFunction(environment, Arrays.asList("first", "second"), new cons()));
        environment.bind("first", new MarcoFunction(environment, Arrays.asList("pair"), new first()));
        environment.bind("second", new MarcoFunction(environment, Arrays.asList("pair"), new second()));
        environment.bind("pair?", new MarcoFunction(environment, Arrays.asList("pair"), new pairquestion()));

        environment.bind("nil?", new MarcoFunction(environment, Arrays.asList("arg"), new nilquestion()));

        environment.bind("+", new MarcoFunction(environment, Arrays.asList("v1", "v2"), new plus()));

        return environment;
    }

    public MarcoObject eval(String code) {
        MarcoProgram program = Parser.instance().parse(code);
        return program.eval(this);
    }
}

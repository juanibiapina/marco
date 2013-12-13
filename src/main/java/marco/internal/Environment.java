package marco.internal;

import marco.internal.bindings.*;
import marco.lang.*;
import marco.lang.exception.MarcoBindingError;
import marco.lang.exception.MarcoLookUpError;
import marco.lang.functions.*;
import marco.lang.functions.numbers.*;
import marco.lang.macros.*;
import marco.parser.Parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map<String, Binding> env = new HashMap<>();

    public Environment() {
    }

    public void def(String var, MarcoObject value) {
        if (env.containsKey(var)) {
            throw new MarcoBindingError(var, value, env.get(var).getValue());
        } else {
            env.put(var, new ImmutableBinding(var, value));
        }
    }

    public void var(String var, MarcoObject value) {
        if (env.containsKey(var)) {
            throw new MarcoBindingError(var, value, env.get(var).getValue());
        } else {
            env.put(var, new MutableBinding(var, value));
        }
    }

    public void parameter(String var, MarcoObject value) {
        env.put(var, new ParameterBinding(var, value));
    }

    public void let(String var, MarcoObject value) {
        env.put(var, new LetBinding(var, value));
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

    public void internalBind(String var, MarcoObject value) {
        env.put(var, new InternalBinding(var, value));
    }

    public Environment duplicate() {
        Map<String, Binding> newEnvMap = new HashMap();
        newEnvMap.putAll(env);
        Environment newEnv = new Environment();
        newEnv.env = newEnvMap;
        return newEnv;
    }

    public MarcoProgram parse(String code) {
        return Parser.instance().parse(code);
    }

    public static Environment initial() {
        Environment environment = new Environment();

        loadNativeBindings(environment);
        loadStandardLibrary(environment);

        return environment;
    }

    private static void loadStandardLibrary(Environment environment) {
        MarcoProgram program = MarcoLoader.load("core");
        program.eval(environment);
    }

    private static void loadNativeBindings(Environment environment) {
        environment.def("function", new function());
        environment.def("function?", new MarcoFunction(environment, Arrays.asList("v"), new functionquestion()));
        environment.def("if", new ifmacro());
        environment.def("and", new and());
        environment.def("or", new or());

        environment.def("quote", new quote());

        environment.def("nil", MarcoNil.NIL);
        environment.def("true", MarcoBoolean.TRUE);
        environment.def("false", MarcoBoolean.FALSE);

        environment.def("def", new def());
        environment.def("var", new var());
        environment.def("set!", new setbang());
        environment.def("let", new let());

        environment.def("print", new MarcoFunction(environment, Arrays.asList("e"), new print()));

        environment.def("parse", new MarcoFunction(environment, Arrays.asList("code"), new parse(Parser.instance())));
        environment.def("eval", new MarcoFunction(environment, Arrays.asList("arg"), new eval()));
        environment.def("do", new domacro());
        environment.def("while", new whilemacro());

        environment.def("cons", new MarcoFunction(environment, Arrays.asList("first", "second"), new cons()));
        environment.def("first", new MarcoFunction(environment, Arrays.asList("pair"), new first()));
        environment.def("second", new MarcoFunction(environment, Arrays.asList("pair"), new second()));
        environment.def("pair?", new MarcoFunction(environment, Arrays.asList("pair"), new pairquestion()));

        environment.def("nil?", new MarcoFunction(environment, Arrays.asList("arg"), new nilquestion()));

        environment.def("=", new BinaryOperator(environment, new equal()));
        environment.def("<", new BinaryOperator(environment, new lessthan()));
        environment.def(">", new BinaryOperator(environment, new greaterthan()));
        environment.def("+", new BinaryOperator(environment, new plus()));
        environment.def("-", new BinaryOperator(environment, new minus()));
        environment.def("*", new BinaryOperator(environment, new multiplication()));
        environment.def("/", new BinaryOperator(environment, new division()));
        environment.def("%", new BinaryOperator(environment, new remainder()));
    }
}

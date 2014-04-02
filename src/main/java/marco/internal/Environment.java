package marco.internal;

import marco.internal.bindings.Binding;
import marco.internal.bindings.ImmutableBinding;
import marco.internal.bindings.MutableBinding;
import marco.lang.*;
import marco.lang.especialforms.setbang;
import marco.lang.especialforms.var;
import marco.lang.especialforms.while_specialform;
import marco.lang.exceptions.BindingError;
import marco.lang.exceptions.LookUpError;
import marco.lang.functions.booleans._if;
import marco.lang.functions.booleans._not;
import marco.lang.functions.data.data;
import marco.lang.functions.def;
import marco.lang.functions.equal_question;
import marco.lang.functions.function.function;
import marco.lang.functions.function.function_question;
import marco.lang.functions.io.print;
import marco.lang.functions.let;
import marco.lang.functions.list.length;
import marco.lang.functions.list.list_question;
import marco.lang.functions.modules.include;
import marco.lang.functions.nil.nil_question;
import marco.lang.functions.number.*;
import marco.lang.functions.pair.cons;
import marco.lang.functions.pair.first;
import marco.lang.functions.pair.pair_question;
import marco.lang.functions.pair.second;
import marco.lang.functions.system.exit;

import java.util.Arrays;
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
        environment.def("function", new MarcoFunction(environment, Arrays.asList("formal", "body"), new function()));
        environment.def("function?", new MarcoFunction(environment, Arrays.asList("v"), new function_question()));

        environment.def("true", MarcoBoolean.TRUE);
        environment.def("false", MarcoBoolean.FALSE);
        environment.def("not", new MarcoFunction(environment, Arrays.asList("e"), new _not()));
        environment.def("if", new MarcoFunction(environment, Arrays.asList("condition", "then-clause", "else-clause"), new _if()));

        environment.def("def", new MarcoFunction(environment, Arrays.asList("name", "value"), new def()));
        environment.def("var", new var());
        environment.def("set!", new setbang());
        environment.def("let", new MarcoFunction(environment, Arrays.asList("binding", "body"), new let()));

        environment.def("while", new while_specialform());

        environment.def("cons", new MarcoFunction(environment, Arrays.asList("first", "second"), new cons()));
        environment.def("first", new MarcoFunction(environment, Arrays.asList("pair"), new first()));
        environment.def("second", new MarcoFunction(environment, Arrays.asList("pair"), new second()));
        environment.def("pair?", new MarcoFunction(environment, Arrays.asList("pair"), new pair_question()));

        environment.def("list?", new MarcoFunction(environment, Arrays.asList("value"), new list_question()));
        environment.def("length", new MarcoFunction(environment, Arrays.asList("l"), new length()));

        environment.def("nil?", new MarcoFunction(environment, Arrays.asList("arg"), new nil_question()));
        environment.def("nil", MarcoNil.NIL);

        environment.def("=", new BinaryOperator(environment, new equal()));
        environment.def("<", new BinaryOperator(environment, new lessthan()));
        environment.def(">", new BinaryOperator(environment, new greaterthan()));
        environment.def("+", new BinaryOperator(environment, new plus()));
        environment.def("-", new BinaryOperator(environment, new minus()));
        environment.def("*", new BinaryOperator(environment, new multiplication()));
        environment.def("/", new BinaryOperator(environment, new division()));
        environment.def("%", new BinaryOperator(environment, new remainder()));

        environment.def("data", new MarcoFunction(environment, Arrays.asList("fields"), new data()));

        environment.def("equal?", new MarcoFunction(environment, Arrays.asList("e1", "e2"), new equal_question()));

        environment.def("include", new MarcoFunction(environment, Arrays.asList("module-name"), new include()));

        environment.def("exit", new MarcoFunction(environment, Arrays.asList("code"), new exit()));

        environment.def("print", new MarcoFunction(environment, Arrays.asList("e"), new print()));
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

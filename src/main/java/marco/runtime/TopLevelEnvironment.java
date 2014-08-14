package marco.runtime;

import marco.lang.MarcoBoolean;
import marco.lang.MarcoFunction;
import marco.lang.MarcoNil;
import marco.lang.functions.*;
import marco.lang.functions.block.invoke;
import marco.lang.functions.block.module;
import marco.lang.functions.booleans._if;
import marco.lang.functions.booleans._not;
import marco.lang.functions.function.function;
import marco.lang.functions.function.function_question;
import marco.lang.functions.hash_map.hash_map;
import marco.lang.functions.io.print;
import marco.lang.functions.metadata.meta;
import marco.lang.functions.module.export;
import marco.lang.functions.module.include;
import marco.lang.functions.module.require;
import marco.lang.functions.module.require_native;
import marco.lang.functions.nil.nil_question;
import marco.lang.functions.number.*;
import marco.lang.functions.pair.first;
import marco.lang.functions.pair.pair;
import marco.lang.functions.pair.pair_question;
import marco.lang.functions.pair.second;
import marco.lang.functions.string.string_concat;
import marco.lang.functions.system.exit;

import java.util.Arrays;

public class TopLevelEnvironment extends Environment {
    public TopLevelEnvironment(MarcoRuntime runtime) {
        super(runtime);
        loadNativeBindings();
    }

    private void loadNativeBindings() {
        def("function", new MarcoFunction(this, Arrays.asList("formal", "body"), new function()));
        def("function?", new MarcoFunction(this, Arrays.asList("v"), new function_question()));

        def("true", MarcoBoolean.TRUE);
        def("false", MarcoBoolean.FALSE);
        def("not", new MarcoFunction(this, Arrays.asList("e"), new _not()));
        def("if", new MarcoFunction(this, Arrays.asList("condition", "then-clause", "else-clause"), new _if()));

        def("def", new MarcoFunction(this, Arrays.asList("name", "value"), new def()));
        def("var", new MarcoFunction(this, Arrays.asList("name", "value"), new var()));
        def("set!", new MarcoFunction(this, Arrays.asList("name", "value"), new setbang()));
        def("let", new MarcoFunction(this, Arrays.asList("binding", "body"), new let()));

        def("while", new MarcoFunction(this, Arrays.asList("cond", "body"), new _while()));

        def("nil?", new MarcoFunction(this, Arrays.asList("arg"), new nil_question()));
        def("nil", MarcoNil.NIL);

        def("=", new BinaryOperator(this, new equal()));
        def("<", new BinaryOperator(this, new lessthan()));
        def("<=", new BinaryOperator(this, new lessthanorequal()));
        def(">", new BinaryOperator(this, new greaterthan()));
        def(">=", new BinaryOperator(this, new greaterthanorequal()));
        def("+", new BinaryOperator(this, new plus()));
        def("-", new BinaryOperator(this, new minus()));
        def("*", new BinaryOperator(this, new multiplication()));
        def("/", new BinaryOperator(this, new division()));
        def("%", new BinaryOperator(this, new remainder()));

        def("equal?", new MarcoFunction(this, Arrays.asList("e1", "e2"), new equal_question()));

        def("include", new MarcoFunction(this, Arrays.asList("module-name"), new include()));
        def("require", new MarcoFunction(this, Arrays.asList("module-name"), new require()));
        def("require-native", new MarcoFunction(this, Arrays.asList("module-name"), new require_native()));

        def("exit", new MarcoFunction(this, Arrays.asList("code"), new exit()));

        def("print", new MarcoFunction(this, Arrays.asList("e"), new print()));

        def("string-concat", new MarcoFunction(this, Arrays.asList("values"), new string_concat()));

        def("invoke", new MarcoFunction(this, Arrays.asList("block"), new invoke()));
        def("module", new MarcoFunction(this, Arrays.asList("block"), new module()));
        def("export", new MarcoFunction(this, Arrays.asList("symbols"), new export()));

        def("pair", new MarcoFunction(this, Arrays.asList("e1", "e2"), new pair()));
        def("first", new MarcoFunction(this, Arrays.asList("pair"), new first()));
        def("second", new MarcoFunction(this, Arrays.asList("pair"), new second()));
        def("pair?", new MarcoFunction(this, Arrays.asList("value"), new pair_question()));

        def("hash-map", new MarcoFunction(this, Arrays.asList("mappings"), new hash_map()));

        def("meta", new MarcoFunction(this, Arrays.asList("value"), new meta()));
    }
}

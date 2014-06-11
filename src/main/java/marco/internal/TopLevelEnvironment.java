package marco.internal;

import marco.lang.*;
import marco.lang.exceptions.MarcoException;
import marco.lang.functions.*;
import marco.lang.functions.booleans._if;
import marco.lang.functions.booleans._not;
import marco.lang.functions.data.data;
import marco.lang.functions.function.function;
import marco.lang.functions.function.function_question;
import marco.lang.functions.io.print;
import marco.lang.functions.list.length;
import marco.lang.functions.list.list_question;
import marco.lang.functions.modules.include;
import marco.lang.functions.nil.nil_question;
import marco.lang.functions.number.*;
import marco.lang.functions.pair.cons;
import marco.lang.functions.pair.first;
import marco.lang.functions.pair.pair_question;
import marco.lang.functions.pair.second;
import marco.lang.functions.string.string_concat;
import marco.lang.functions.system.exit;
import marco.parser.Parser;

import java.io.InputStream;
import java.util.Arrays;

public class TopLevelEnvironment extends Environment {
    public TopLevelEnvironment() {
        loadNativeBindings();
        loadStandardLibrary();
    }

    public static MarcoObject load(String name) {
        InputStream in = Environment.class.getClassLoader().getResourceAsStream("marco/" + name + ".mrc");

        if (in == null) {
            throw new MarcoException("could not find " + name);
        }

        return Parser.instance().parse(in);
    }

    private void loadStandardLibrary() {
        MarcoObject program = load("core");
        program.eval(this);
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

        def("cons", new MarcoFunction(this, Arrays.asList("first", "second"), new cons()));
        def("first", new MarcoFunction(this, Arrays.asList("pair"), new first()));
        def("second", new MarcoFunction(this, Arrays.asList("pair"), new second()));
        def("pair?", new MarcoFunction(this, Arrays.asList("pair"), new pair_question()));

        def("list?", new MarcoFunction(this, Arrays.asList("value"), new list_question()));
        def("length", new MarcoFunction(this, Arrays.asList("l"), new length()));

        def("nil?", new MarcoFunction(this, Arrays.asList("arg"), new nil_question()));
        def("nil", MarcoNil.NIL);

        def("=", new BinaryOperator(this, new equal()));
        def("<", new BinaryOperator(this, new lessthan()));
        def(">", new BinaryOperator(this, new greaterthan()));
        def("+", new BinaryOperator(this, new plus()));
        def("-", new BinaryOperator(this, new minus()));
        def("*", new BinaryOperator(this, new multiplication()));
        def("/", new BinaryOperator(this, new division()));
        def("%", new BinaryOperator(this, new remainder()));

        def("data", new MarcoFunction(this, Arrays.asList("fields"), new data()));

        def("equal?", new MarcoFunction(this, Arrays.asList("e1", "e2"), new equal_question()));

        def("include", new MarcoFunction(this, Arrays.asList("module-name"), new include()));

        def("exit", new MarcoFunction(this, Arrays.asList("code"), new exit()));

        def("print", new MarcoFunction(this, Arrays.asList("e"), new print()));

        def("string-concat", new MarcoFunction(this, Arrays.asList("values"), new string_concat()));
    }
}

package marco.lang;

import marco.internal.Environment;
import marco.lang.functions.eval;

import java.util.Arrays;
import java.util.List;

public class MarcoMacro extends MarcoRunnable {
    private final Environment closureEnv;
    private List<String> parameters;
    private MarcoObject body;
    private int arity;

    public MarcoMacro(Environment environment, List<String> parameters, MarcoObject body) {
        this.closureEnv = environment;
        this.parameters = parameters;
        this.body = body;
        this.arity = parameters.size();
    }

    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(arity, arguments.size());

        Environment extendedEnv = closureEnv.duplicate();
        extendedEnv.internalBind("eval", new MarcoFunction(environment, Arrays.asList("arg"), new eval()));
        for (int i = 0; i < arguments.size(); i++) {
            MarcoObject arg = arguments.get(i);
            String parameterName = parameters.get(i);
            extendedEnv.parameter(parameterName, arg);
        }

        return body.eval(extendedEnv);
    }

    @Override
    public String typeName() {
        return "Macro";
    }
}

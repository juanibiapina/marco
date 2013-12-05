package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoFunction extends MarcoRunnable {
    private final Environment closureEnv;
    private final List<String> parameters;
    private final MarcoObject body;
    private final int arity;

    public MarcoFunction(Environment environment, List<String> parameters, MarcoObject body) {
        this.closureEnv = environment;
        this.parameters = parameters;
        this.body = body;
        this.arity = parameters.size();
    }

    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        assertArity(arity, arguments.size());

        Environment extendedEnv = closureEnv.duplicate();
        for (int i = 0; i < arguments.size(); i++) {
            MarcoObject evaluatedArg = arguments.get(i).eval(environment);
            String parameterName = parameters.get(i);
            extendedEnv.parameter(parameterName, evaluatedArg);
        }
        return body.eval(extendedEnv);
    }

    @Override
    public String typeName() {
        return "Function";
    }
}

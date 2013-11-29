package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoFunction extends MarcoRunnable {
    private final Environment closureEnv;
    private final List<String> parameters;
    private final MarcoObject body;
    private final boolean variadic;

    public MarcoFunction(Environment environment, List<String> parameters, MarcoObject body) {
        this.closureEnv = environment;
        this.parameters = parameters;
        this.body = body;
        this.variadic = false;
    }

    public MarcoFunction(Environment environment, List<String> parameters, MarcoObject body, boolean variadic) {
        this.closureEnv = environment;
        this.parameters = parameters;
        this.body = body;
        this.variadic = variadic;
    }

    @Override
    public MarcoObject call(Environment environment, MarcoList arguments) {
        if (!variadic) {
            assertArity(parameters.size(), arguments.size());
        }

        Environment extendedEnv = closureEnv.duplicate();

        if (variadic) {
            extendedEnv.rebind(parameters.get(0), (MarcoObject) arguments);
        } else {
            for (int i = 0; i < arguments.size(); i++) {
                MarcoObject evaluatedArg = arguments.get(i).eval(environment);
                String parameterName = parameters.get(i);
                extendedEnv.rebind(parameterName, evaluatedArg);
            }
        }

        return body.eval(extendedEnv);
    }

    @Override
    public String typeName() {
        return "Function";
    }
}

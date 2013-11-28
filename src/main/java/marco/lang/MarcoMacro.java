package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoMacro extends MarcoRunnable {
    private final Environment closureEnv;
    private List<String> parameters;
    private MarcoForm body;
    private int arity;

    public MarcoMacro(Environment environment, List<String> parameters, MarcoForm body) {
        this.closureEnv = environment;
        this.parameters = parameters;
        this.body = body;
        this.arity = parameters.size();
    }

    @Override
    public MarcoObject call(Environment environment, List<MarcoForm> arguments) {
        assertArity(arity, arguments.size());

        Environment extendedEnv = closureEnv.duplicate();
        for (int i = 0; i < arguments.size(); i++) {
            MarcoObject evaluatedArg = arguments.get(i);
            String parameterName = parameters.get(i);
            extendedEnv.rebind(parameterName, evaluatedArg);
        }

        return body.eval(extendedEnv);
    }

    @Override
    public String typeName() {
        return "Macro";
    }
}

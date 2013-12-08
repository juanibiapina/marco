package marco.lang;

import marco.internal.Environment;
import marco.lang.contracts.Contract;
import marco.lang.functions.eval;

import java.util.Arrays;
import java.util.List;

public class MarcoMacro extends MarcoRunnable {
    private final Environment closureEnv;
    private List<String> parameters;
    private MarcoObject body;

    public MarcoMacro(Environment environment, List<String> parameters, MarcoObject body) {
        super(new Contract(parameters.size()));
        this.closureEnv = environment;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
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

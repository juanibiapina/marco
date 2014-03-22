package marco.lang;

import marco.internal.Environment;
import marco.internal.bindings.ImmutableBinding;
import marco.internal.bindings.ParameterBinding;
import marco.lang.contracts.Contract;

import java.util.ArrayList;
import java.util.List;

public class MarcoFunction extends MarcoRunnable {
    private final Environment closureEnv;
    private final List<String> parameters;
    private final MarcoObject body;

    public MarcoFunction(Environment environment, List<String> parameters, MarcoObject body) {
        super(new Contract(parameters.size()));

        List<String> freeVariables = new ArrayList<>();
        freeVariables.addAll(body.freeVariables());
        freeVariables.removeAll(parameters);

        this.closureEnv = environment.filter(freeVariables);
        this.closureEnv.forceAdd(new ImmutableBinding("recur", this));
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        Environment extendedEnv = closureEnv.duplicate();
        for (int i = 0; i < arguments.length(); i++) {
            MarcoObject evaluatedArg = arguments.get(i).eval(environment);
            String parameterName = parameters.get(i);
            extendedEnv.forceAdd(new ParameterBinding(parameterName, evaluatedArg));
        }
        return new MarcoContinuation(body, extendedEnv);
    }

    @Override
    public String typeName() {
        return "Function";
    }
}

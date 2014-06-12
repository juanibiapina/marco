package marco.lang;

import marco.internal.Environment;
import marco.lang.contracts.Contract;

import java.util.List;

public class MarcoFunction extends MarcoRunnable {
    private final List<String> parameters;
    private final MarcoBlock body;
    private Environment environment;

    public MarcoFunction(Environment environment, List<String> parameters, MarcoBlock body) {
        super(new Contract(parameters.size()));

        this.environment = environment;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        Environment closure = this.environment.spawn();
        closure.let("recurse", this);

        for (int i = 0; i < arguments.length(); i++) {
            MarcoObject evaluatedArg = arguments.get(i).eval(environment);
            String parameterName = parameters.get(i);
            closure.parameter(parameterName, evaluatedArg);
        }
        return new MarcoContinuation(new MarcoBlockInvocation(body), closure, environment);
    }

    @Override
    public String typeName() {
        return "Function";
    }

    @Override
    public String asString() {
        return toString();
    }
}

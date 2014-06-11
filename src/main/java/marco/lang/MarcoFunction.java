package marco.lang;

import marco.internal.Environment;
import marco.internal.bindings.ImmutableBinding;
import marco.internal.bindings.ParameterBinding;
import marco.lang.contracts.Contract;

import java.util.ArrayList;
import java.util.List;

public class MarcoFunction extends MarcoRunnable {
    private final List<String> parameters;
    private final MarcoBlock body;
    private Environment environment;

    public MarcoFunction(Environment environment, List<String> parameters, MarcoBlock body) {
        super(new Contract(parameters.size()));

        List<String> freeVariables = new ArrayList<>();
        freeVariables.addAll(body.freeVariables());
        freeVariables.removeAll(parameters);

        this.environment = environment;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public MarcoObject performInvoke(Environment environment, MarcoList arguments) {
        Environment closure = this.environment.spawn();
        closure.addSlot(new ImmutableBinding("recurse", this));

        for (int i = 0; i < arguments.length(); i++) {
            MarcoObject evaluatedArg = arguments.get(i).eval(environment);
            String parameterName = parameters.get(i);
            closure.addSlot(new ParameterBinding(parameterName, evaluatedArg));
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

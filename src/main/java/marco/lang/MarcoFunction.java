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
    public MarcoObject performInvoke(Environment environment, List<MarcoObject> arguments) {
        Environment closure = this.environment.spawn();
        closure.let("recurse", this);

        for (int i = 0; i < arguments.size(); i++) {
            String parameterName = parameters.get(i);
            closure.parameter(parameterName, arguments.get(i));
        }
        return body.invoke(closure, environment);
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

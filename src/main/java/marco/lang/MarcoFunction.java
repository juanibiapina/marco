package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoFunction extends MarcoRunnable {
    private final List<String> parameters;
    private final MarcoBlock body;
    private Environment lexical;

    public MarcoFunction(Environment lexical, List<String> parameters, MarcoBlock body) {
        super(parameters.size());

        this.lexical = lexical;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public MarcoObject performInvoke(Environment dynamic, List<MarcoObject> arguments) {
        Environment closure = this.lexical.spawn();
        closure.let("recurse", this);

        for (int i = 0; i < arguments.size(); i++) {
            String parameterName = parameters.get(i);
            closure.parameter(parameterName, arguments.get(i));
        }
        return body.invoke(closure, dynamic);
    }

    @Override
    public String typeName() {
        return "Function";
    }

    @Override
    public String convertToString() {
        return toString();
    }
}

package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoInvocation extends MarcoObject {
    private MarcoRunnable operator;
    private List<MarcoObject> arguments;
    private Environment closure;
    private Environment environment;

    public MarcoInvocation(MarcoRunnable operator, List<MarcoObject> arguments, Environment closure, Environment environment) {
        this.operator = operator;
        this.arguments = arguments;
        this.closure = closure;
        this.environment = environment;
    }

    @Override
    protected MarcoObject doEval(Environment closure, Environment environment) {
        return operator.invoke(this.closure, arguments);
    }

    @Override
    public String typeName() {
        return "Invocation";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return true;
    }

    @Override
    public String asString() {
        return toString();
    }
}

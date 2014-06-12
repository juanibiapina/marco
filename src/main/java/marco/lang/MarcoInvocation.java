package marco.lang;

import marco.internal.Environment;

import java.util.List;

public class MarcoInvocation extends MarcoObject {
    private MarcoRunnable operator;
    private List<MarcoObject> arguments;

    public MarcoInvocation(MarcoRunnable operator, List<MarcoObject> arguments) {
        this.operator = operator;
        this.arguments = arguments;
    }

    @Override
    protected MarcoObject doEval(Environment closure, Environment environment) {
        return operator.invoke(closure, arguments);
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
        return false;
    }

    @Override
    public String asString() {
        return toString();
    }
}

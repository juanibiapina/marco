package marco.lang;

import marco.internal.Environment;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class MarcoApplication extends MarcoObject {
    private MarcoRunnable operator;
    private MarcoList arguments;

    public MarcoApplication(MarcoRunnable operator, MarcoList arguments) {
        this.operator = operator;
        this.arguments = arguments;
    }

    @Override
    public MarcoObject doEval(Environment environment) {
        return operator.invoke(environment, arguments);
    }

    @Override
    public String typeName() {
        return "Application";
    }

    @Override
    public List<String> freeVariables() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public boolean isContinuation() {
        return false;
    }
}

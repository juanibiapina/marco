package marco.lang;

import marco.internal.Environment;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class MarcoContinuation extends MarcoObject {
    private MarcoObject value;
    private Environment environment;
    private Environment closure;

    public MarcoContinuation(MarcoObject value, Environment closure, Environment environment) {
        this.value = value;
        this.environment = environment;
        this.closure = closure;
    }

    @Override
    public MarcoObject doEval(Environment closure, Environment environment) {
        return value.doEval(this.closure, this.environment);
    }

    @Override
    public String typeName() {
        return "Continuation";
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
        return true;
    }
}

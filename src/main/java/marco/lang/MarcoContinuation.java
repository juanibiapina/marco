package marco.lang;

import marco.internal.Environment;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class MarcoContinuation extends MarcoObject {
    private MarcoObject value;
    private Environment closure;

    public MarcoContinuation(MarcoObject value, Environment closure) {
        this.value = value;
        this.closure = closure;
    }

    @Override
    public MarcoObject doEval(Environment environment, Environment global) {
        return value.doEval(closure, global);
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

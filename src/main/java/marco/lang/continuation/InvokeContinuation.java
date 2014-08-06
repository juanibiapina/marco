package marco.lang.continuation;

import marco.lang.MarcoBlock;
import marco.lang.MarcoObject;
import marco.lang.MarcoValue;
import marco.runtime.Environment;

public class InvokeContinuation extends MarcoValue {
    private MarcoBlock block;
    private Environment closure;
    private Environment dynamic;

    public InvokeContinuation(MarcoBlock block, Environment closure, Environment dynamic) {
        this.block = block;
        this.closure = closure;
        this.dynamic = dynamic;
    }

    @Override
    public String typeName() {
        return "Continuation";
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return null;
    }

    @Override
    public boolean isContinuation() {
        return true;
    }

    @Override
    public MarcoObject resolve() {
        return block.invoke(closure, dynamic);
    }
}
